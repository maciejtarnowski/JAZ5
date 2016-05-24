package rest;

import domain.RepositoryException;
import domain.comment.Comment;
import domain.comment.CommentRepository;
import domain.film.Film;
import domain.film.FilmRepository;
import domain.rating.Rating;
import domain.rating.RatingRepository;
import domain.rating.RatingSummary;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.OptionalDouble;

@Path("/films")
public class FilmResource {
    private FilmRepository filmRepository = RepositoryRegistry.getFilmRepository();
    private CommentRepository commentRepository = RepositoryRegistry.getCommentRepository();
    private RatingRepository ratingRepository = RepositoryRegistry.getRatingRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilms() {
        return filmRepository.getFilms();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Film addFilm(Film film) {
        filmRepository.addFilm(film);

        return film;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilm(@PathParam("id") Integer id) {
        Film film = filmRepository.getFilmById(id);
        if (film == null) {
            return Response.status(404).build();
        }
        return Response.ok(film).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFilm(@PathParam("id") Integer id, Film film) {
        film.setId(id);
        Film updatedFilm;
        try {
            updatedFilm = filmRepository.updateFilm(film);
        } catch (RepositoryException e) {
            return Response.status(404).build();
        }
        return Response.ok(updatedFilm).build();
    }

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments(@PathParam("id") Integer id) {
        if (filmRepository.getFilmById(id) == null) {
            return Response.status(404).build();
        }

        return Response.ok(commentRepository.getCommentsForFilm(id)).build();
    }

    @POST
    @Path("/{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment(@PathParam("id") Integer id, Comment comment) {
        if (filmRepository.getFilmById(id) == null) {
            return Response.status(404).build();
        }

        comment.setCreatedAt(new Date());
        comment.setFilmId(id);

        commentRepository.addComment(comment);

        return Response.ok(comment).build();
    }

    @DELETE
    @Path("/{id}/comments/{commentId}")
    public Response deleteComment(@PathParam("commentId") Integer commentId) {
        try {
            commentRepository.deleteCommentById(commentId);
        } catch (RepositoryException e) {
            return Response.status(404).build();
        }
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/ratings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRatings(@PathParam("id") Integer id) {
        if (filmRepository.getFilmById(id) == null) {
            return Response.status(404).build();
        }

        return Response.ok(ratingRepository.getSummaryForFilm(id)).build();
    }

    @POST
    @Path("/{id}/ratings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRating(@PathParam("id") Integer id, Rating rating) {
        if (filmRepository.getFilmById(id) == null) {
            return Response.status(404).build();
        }

        rating.setFilmId(id);
        ratingRepository.addRating(rating);

        return Response.ok().build();
    }
}
