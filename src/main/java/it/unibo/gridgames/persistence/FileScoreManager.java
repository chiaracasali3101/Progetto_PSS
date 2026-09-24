package it.unibo.gridgames.persistence;

import java.nio.file.Path;
import java.util.Objects;

import it.unibo.gridgames.model.GameRecord;
import it.unibo.gridgames.model.GameType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileScoreManager implements ScoreManager {
    private final Path filePath;

    //riceve dall'esterno il percorso del file
    public FileScoreManager(String filePath) {
        this.filePath = Path.of(filePath);
    }


    //implementazione dei tre metodi 

    @Override
    public void saveScore(final GameRecord record) throws IOException {
        //implementazione per salvare il punteggio nel file
        synchronized (this) {

            //controllo valori nulli 
            Objects.requireNonNull(record, "Record cannot be null");

            //logica per salvare il record nel file
            final String playerName = record.getPlayerName();
            final int score = record.getScore();
            final String gameType = record.getGameType();
            final int moves = record.getMoves();
            final long durationSeconds = record.getDurationSeconds();
            final LocalDateTime timestamp = record.getTimestamp();

            String line = String.format("%s,%s,%d,%d,%d,%s%n", playerName, gameType, score, moves, durationSeconds, timestamp);

            //scrittura nel file
            try (BufferedWriter writer = Files.newBufferedWriter(
                this.filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write(line);
        }
        }
    }

    @Override 
    public List<GameRecord> loadAllScores() throws IOException {
        //implementazione per caricare tutti i punteggi dal file

        //se il file non esiste ritorna una lista vuota (primo accesso)
        if (!Files.exists(this.filePath)) {
            return List.of();
        }

        //lettura di tutte le righe del file e conversione
        final List<String> lines = Files.readAllLines(this.filePath);
        final List<GameRecord> records = new ArrayList<>();

        for (final String line : lines) {
            if (line.isBlank()) {
                continue;
            }
    
            final String[] tokens = line.split(",");
            if (tokens.length >= 6) {
                final String playerName = tokens[0].trim();
                final String gameType = tokens[1].trim();
                final int score = Integer.parseInt(tokens[2].trim());
                final int moves = Integer.parseInt(tokens[3].trim());
                // tokens[4] è durationSeconds, che GameRecord attualmente imposta a 0
                final LocalDateTime timestamp = LocalDateTime.parse(tokens[5].trim());

                final GameRecord record = new GameRecord(playerName, score, gameType, moves, timestamp);
                records.add(record);
            }
        }
        return List.copyOf(records);
    }

    @Override 
    public List<GameRecord> getTopScores(final GameType gameType, final int limit) {
        Objects.requireNonNull(gameType, "GameType cannot be null");

        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be positive");
        }

        try {
            return loadAllScores().stream()
                .filter(record -> record.getGameType().equals(gameType.name())) // <-- USA .name() QUI
                .sorted(Comparator.comparingInt(GameRecord::getScore).reversed())
                .limit(limit)
                .collect(Collectors.toList());
        } catch (IOException e) {
            return List.of();
        }
    }
}
