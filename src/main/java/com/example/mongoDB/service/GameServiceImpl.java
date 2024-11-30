package com.example.mongoDB.service;

import com.example.mongoDB.model.Game;
import com.example.mongoDB.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game game) {
        gameRepository.save(game);
        return game;
    }

    @Override
    public void saveGames(List<Game> games) {
        gameRepository.saveAll(games);
    }

    @Override
    public void deleteGameById(String id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void deleteAllGames() {
        gameRepository.deleteAll();
    }

    @Override
    public Game getGameById(String id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Игра с id=" + id + " не найдена"));
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public long countGames() {
        return gameRepository.count();
    }

    @Override
    public List<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }

    @Override
    public List<Game> findByDeveloper(String developer) {
        return gameRepository.findByDeveloper(developer);
    }

    @Override
    public List<Game> findByPrice(int price) {
        return gameRepository.findByPrice(price);
    }

    @Override
    public List<Game> findByReleaseYear(int releaseYear) {
        return gameRepository.findByReleaseYear(releaseYear);
    }

    @Override
    public List<Game> findByGenreContaining(String genre) {
        return gameRepository.findByGenreContaining(genre);
    }

    @Override
    public List<Game> findByPlatformsContaining(String platform) {
        return gameRepository.findByPlatformsContaining(platform);
    }

    @Override
    public List<Game> findByPriceGreaterThan(int price) {
        return gameRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Game> findByReleaseYearGreaterThan(int releaseYear) {
        return gameRepository.findByReleaseYearGreaterThan(releaseYear);
    }

    @Override
    public List<Game> findByPriceBetween(int minPrice, int maxPrice) {
        return gameRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Game> findByNameIgnoreCase(String name) {
        return gameRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Game> findByPriceLessThan(int price) {
        return gameRepository.findByPriceLessThan(price);
    }

    @Override
    public List<Game> findByReleaseYearBetween(int startYear, int endYear) {
        return gameRepository.findByReleaseYearBetween(startYear, endYear);
    }

    @Override
    public Page<Game> getGames(PageRequest pageRequest) {
        return gameRepository.findAll(pageRequest);
    }
}
