package com.example.mongoDB.controller;

import com.example.mongoDB.model.Game;
import com.example.mongoDB.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("")
    public Page<Game> getGamesPage(
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        return gameService.getGames(PageRequest.of(offset, limit));
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable String id) {
        return gameService.getGameById(id);
    }

    @PostMapping("")
    public Game addGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameService.deleteGameById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllGames() {
        gameService.deleteAllGames();
    }

    @PutMapping("{id}")
    public Game putGame(@RequestBody Game newGame, @PathVariable String id) {
        newGame.setId(id);
        return gameService.saveGame(newGame);
    }

    @GetMapping("/count")
    public long countGames() {
        return gameService.countGames();
    }

    @GetMapping("/search/name")
    public List<Game> searchByName(@RequestParam String name) {
        return gameService.findByName(name);
    }

    @GetMapping("/search/developer")
    public List<Game> searchByDeveloper(@RequestParam String developer) {
        return gameService.findByDeveloper(developer);
    }

    @GetMapping("/search/price")
    public List<Game> searchByPrice(@RequestParam int price) {
        return gameService.findByPrice(price);
    }

    @GetMapping("/search/priceBetween")
    public List<Game> searchByPriceBetween(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return gameService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/search/releaseYear")
    public List<Game> searchByReleaseYear(@RequestParam int releaseYear) {
        return gameService.findByReleaseYear(releaseYear);
    }

    @GetMapping("/search/genre")
    public List<Game> searchByGenre(@RequestParam String genre) {
        return gameService.findByGenreContaining(genre);
    }

    @GetMapping("/search/platform")
    public List<Game> searchByPlatform(@RequestParam String platform) {
        return gameService.findByPlatformsContaining(platform);
    }

    @GetMapping("/search/priceGreaterThan")
    public List<Game> searchByPriceGreaterThan(@RequestParam int price) {
        return gameService.findByPriceGreaterThan(price);
    }

    @GetMapping("/search/releaseYearGreaterThan")
    public List<Game> searchByReleaseYearGreaterThan(@RequestParam int releaseYear) {
        return gameService.findByReleaseYearGreaterThan(releaseYear);
    }

    @GetMapping("/search/priceLessThan")
    public List<Game> searchByPriceLessThan(@RequestParam int price) {
        return gameService.findByPriceLessThan(price);
    }

    @GetMapping("/search/nameIgnoreCase")
    public List<Game> searchByNameIgnoreCase(@RequestParam String name) {
        return gameService.findByNameIgnoreCase(name);
    }

    @GetMapping("/search/releaseYearBetween")
    public List<Game> searchByReleaseYearBetween(@RequestParam int startYear, @RequestParam int endYear) {
        return gameService.findByReleaseYearBetween(startYear, endYear);
    }
}
