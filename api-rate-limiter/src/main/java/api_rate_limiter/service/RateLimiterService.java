package api_rate_limiter.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {

    private final ConcurrentHashMap<String, Integer> requestCounts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> requestTimes = new ConcurrentHashMap<>();

    private static final int LIMIT = 5;
    private static final long TIME_WINDOW = 10000;

    public boolean allowRequest(String ip) {

        long currentTime = System.currentTimeMillis();

        requestTimes.putIfAbsent(ip, currentTime);
        requestCounts.putIfAbsent(ip, 0);

        if (currentTime - requestTimes.get(ip) > TIME_WINDOW) {
            requestTimes.put(ip, currentTime);
            requestCounts.put(ip, 0);
        }

        int count = requestCounts.get(ip);

        if (count >= LIMIT) {
            return false;
        }

        requestCounts.put(ip, count + 1);
        return true;
    }
}