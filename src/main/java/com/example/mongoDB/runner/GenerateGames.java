package com.example.mongoDB.runner;

import com.example.mongoDB.model.Game;
import com.example.mongoDB.service.GameService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GenerateGames implements CommandLineRunner {
    private static final int LIST_SIZE = 1000;
    private static final List<String> GENRES = List.of("RPG", "Shooter", "Strategy", "Adventure", "Simulation");
    private static final List<String> PLATFORMS = List.of("PC", "PlayStation", "Xbox", "Switch");
    private static final Random random = new Random();

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... args) throws Exception {
        List<Game> games = generateGames();
        System.out.println("Generated " + games.size() + " games");
        gameService.saveGames(games);
    }

    private List<Game> generateGames() {
        Faker faker = new Faker();
        List<Game> games = new ArrayList<>(LIST_SIZE);
        for (int i = 0; i < LIST_SIZE; i++) {
            games.add(new Game(
                    faker.esports().game(),
                    faker.company().name(),
                    random.nextInt(10, 100) * 100 + 99,
                    2000 + random.nextInt(24),
                    getGenres(),
                    getPlatforms()
            ));
        }
        return games;
    }

    private List<String> getGenres() {
        int size = random.nextInt(1, 6);
        List<String> genres = new ArrayList<>(size);
        while (genres.size() < size) {
            genres.add(GENRES.get(random.nextInt(GENRES.size())));
        }
        return new ArrayList<>(new HashSet<>(genres));
    }

    private List<String> getPlatforms() {
        int size = random.nextInt(1, 6);
        List<String> platforms = new ArrayList<>(size);
        while (platforms.size() < size) {
            platforms.add(PLATFORMS.get(random.nextInt(PLATFORMS.size())));
        }
        return new ArrayList<>(new HashSet<>(platforms));
    }
}
