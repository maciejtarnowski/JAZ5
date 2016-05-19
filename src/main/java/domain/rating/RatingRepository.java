package domain.rating;

import java.util.List;

public interface RatingRepository {
    public void addRating(Rating rating);
    public List<Rating> getRatingsForFilm(Integer filmId);
}
