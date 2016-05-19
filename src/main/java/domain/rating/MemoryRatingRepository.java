package domain.rating;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryRatingRepository implements RatingRepository {
    private List<Rating> ratings = new ArrayList<>();

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
}
