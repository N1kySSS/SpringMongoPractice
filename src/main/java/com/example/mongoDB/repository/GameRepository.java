package com.example.mongoDB.repository;

import com.example.mongoDB.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
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
}
