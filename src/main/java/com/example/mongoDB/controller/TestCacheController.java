package com.example.mongoDB.controller;

import com.example.mongoDB.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestCacheController {
    private final GameService gameService;

    public TestCacheController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/cache")
    public String testWithCache() {
        gameService.getGamesWithCache();
        return "Test with cache executed";
    }
}