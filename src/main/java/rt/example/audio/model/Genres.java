package rt.example.audio.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public enum Genres {
    NOVEL("NOVEL"),
    PROSE("PROSE"),
    BIOGRAPHY("BIOGRAPHY"),
    ROCK("ROCK"),
    RAP("RAP"),
    POP("POP"),
    METAL("METAL"),
    CLASSICAL("CLASSICAL");

    private static final Map<String, Genres> existingGenres =
        Arrays.stream(Genres.values()).collect(Collectors.toMap(Genres::getGenre, genre -> genre));

    private final String genre;

    Genres(String genre) {
        this.genre = genre;
    }

    public static Set<Genres> filterRequestGenres(Set<String> strings) {
        return strings.stream()
            .map(String::toUpperCase)
            .map(existingGenres::get)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
    }

    public String getGenre() {
        return genre;
    }
}