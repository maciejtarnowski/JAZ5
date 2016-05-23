package rest;

import domain.RepositoryException;
import domain.film.Film;
import domain.film.FilmRepository;
import domain.film.MemoryFilmRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/films")
public class FilmResource {
    private FilmRepository filmRepository = new MemoryFilmRepository();

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
}
