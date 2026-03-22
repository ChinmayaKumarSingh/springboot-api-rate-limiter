package api_rate_limiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api_rate_limiter.service.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApiController {

    private final RateLimiterService rateLimiterService;

    public ApiController(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @GetMapping("/api/test")
    public String testApi(HttpServletRequest request) {

        String ip = request.getRemoteAddr();

        if (!rateLimiterService.allowRequest(ip)) {
            return "Too many requests ❌";
        }

        return "API request successful 🚀";
    }
}