package com.example.mongoDB.service;

import com.example.mongoDB.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface GameService {
    Game saveGame(Game game);

    void saveGames(List<Game> games);

    void deleteGameById(String id);

    void deleteAllGames();

    List<Game> getAllGames();

    Game getGameById(String id);

    long countGames();

    List<Game> findByName(String name);

    List<Game> findByDeveloper(String developer);

    List<Game> findByPrice(int price);

    List<Game> findByReleaseYear(int releaseYear);

    List<Game> findByGenreContaining(String genre);

    List<Game> findByPlatformsContaining(String platform);

    List<Game> findByPriceGreaterThan(int price);

    List<Game> findByReleaseYearGreaterThan(int releaseYear);

    List<Game> findByPriceBetween(int minPrice, int maxPrice);

    List<Game> findByNameIgnoreCase(String name);

    List<Game> findByPriceLessThan(int price);

    List<Game> findByReleaseYearBetween(int startYear, int endYear);

    Page<Game> getGames(PageRequest pageRequest);
}
