package rest;

import domain.comment.CommentRepository;
import domain.comment.MemoryCommentRepository;
import domain.film.FilmRepository;
import domain.film.MemoryFilmRepository;
import domain.rating.MemoryRatingRepository;
import domain.rating.RatingRepository;

public class RepositoryRegistry {
    private static CommentRepository commentRepository = new MemoryCommentRepository();
    private static FilmRepository filmRepository = new MemoryFilmRepository();
    private static RatingRepository ratingRepository = new MemoryRatingRepository();

    public static CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public static FilmRepository getFilmRepository() {
        return filmRepository;
    }

    public static RatingRepository getRatingRepository() {
        return ratingRepository;
    }
}
