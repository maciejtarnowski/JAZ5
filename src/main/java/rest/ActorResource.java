package rest;

import domain.actor.Actor;
import domain.actor.ActorRepository;
import domain.actorfilm.ActorFilm;
import domain.actorfilm.ActorFilmRepository;
import domain.film.FilmRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/actors")
public class ActorResource {
    private ActorRepository actorRepository = RepositoryRegistry.getActorRepository();
    private ActorFilmRepository actorFilmRepository = RepositoryRegistry.getActorFilmRepository();
    private FilmRepository filmRepository = RepositoryRegistry.getFilmRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Actor addActor(Actor actor) {
        actorRepository.addActor(actor);

        return actor;
    }

    @GET
    @Path("/{id}/films")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmsByActor(@PathParam("id") Integer id) {
        if (actorRepository.getActorById(id) == null) {
            return Response.status(404).build();
        }
        return Response.ok(actorFilmRepository.getFilmsByActor(id)).build();
    }

    @PUT
    @Path("/{id}/films")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignFilmToActor(@PathParam("id") Integer id, ActorFilm actorFilm) {
        if (actorFilm.getFilmId() == null) {
            return Response.status(400).build();
        }
        if (filmRepository.getFilmById(actorFilm.getFilmId()) == null) {
            return Response.status(400).build();
        }
        if (actorRepository.getActorById(id) == null) {
            return Response.status(404).build();
        }

        actorFilmRepository.assignActorToFilm(id, actorFilm.getFilmId());

        return Response.ok().build();
    }
}
