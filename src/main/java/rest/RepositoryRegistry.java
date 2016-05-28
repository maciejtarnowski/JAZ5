package rest;

import domain.actor.ActorRepository;
import domain.actor.MemoryActorRepository;
import domain.actorfilm.ActorFilmRepository;
import domain.actorfilm.MemoryActorFilmRepository;
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
    private static ActorRepository actorRepository = new MemoryActorRepository();
    private static ActorFilmRepository actorFilmRepository = new MemoryActorFilmRepository();

    public static CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public static FilmRepository getFilmRepository() {
        return filmRepository;
    }

    public static RatingRepository getRatingRepository() {
        return ratingRepository;
    }

    public static ActorRepository getActorRepository() {
        return actorRepository;
    }

    public static ActorFilmRepository getActorFilmRepository() {
        return actorFilmRepository;
    }

    public static void setCommentRepository(CommentRepository commentRepository) {
        RepositoryRegistry.commentRepository = commentRepository;
    }

    public static void setFilmRepository(FilmRepository filmRepository) {
        RepositoryRegistry.filmRepository = filmRepository;
    }

    public static void setRatingRepository(RatingRepository ratingRepository) {
        RepositoryRegistry.ratingRepository = ratingRepository;
    }

    public static void setActorRepository(ActorRepository actorRepository) {
        RepositoryRegistry.actorRepository = actorRepository;
    }

    public static void setActorFilmRepository(ActorFilmRepository actorFilmRepository) {
        RepositoryRegistry.actorFilmRepository = actorFilmRepository;
    }
}
