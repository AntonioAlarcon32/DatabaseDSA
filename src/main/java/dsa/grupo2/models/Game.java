package dsa.grupo2.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Game {
    private String id;
    private String userId;
    private int score;
    private Instant startDate;
    private Level currentLevel;
    private List<Item> equipment;
    private boolean ended;

    public Game() {
    }

    public Game(String userId) {
        this.id = RandomStringUtils.randomAlphanumeric(8);
        this.userId = userId;
        this.score = 0;
        this.startDate = Instant.now().truncatedTo(ChronoUnit.MICROS);
        this.currentLevel = null;
        this.equipment = null;
        this.ended = false;
    }
}

