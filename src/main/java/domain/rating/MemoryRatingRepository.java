package domain.rating;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MemoryRatingRepository implements RatingRepository {
    private static List<Rating> ratings = new ArrayList<>();

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public List<Rating> getRatingsForFilm(Integer filmId) {
        return ratings.stream()
                .filter(rating -> rating.getFilmId().equals(filmId))
                .collect(Collectors.toList());
    }

    @Override
    public RatingSummary getSummaryForFilm(Integer filmId) {
        List<Rating> ratings = getRatingsForFilm(filmId);
        OptionalDouble averageRatingOption = ratings.stream()
                .mapToInt(Rating::getValue)
                .average();
        Double averageRating = 0.0;
        if (averageRatingOption.isPresent()) {
            averageRating = averageRatingOption.getAsDouble();
        }
        Integer ratingsCount = ratings.size();

        return new RatingSummary(averageRating, ratingsCount);
    }
}
