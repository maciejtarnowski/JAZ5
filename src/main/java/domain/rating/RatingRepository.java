package domain.rating;

import java.util.List;

public interface RatingRepository {
    void addRating(Rating rating);
    List<Rating> getRatingsForFilm(Integer filmId);
    RatingSummary getSummaryForFilm(Integer filmId);
}
