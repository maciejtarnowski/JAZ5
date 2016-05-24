package domain.actorfilm;

import domain.actor.Actor;
import domain.film.Film;

import java.util.List;

public interface ActorFilmRepository {
    List<Film> getFilmsByActor(Integer actorId);
    List<Actor> getActorsByFilm(Integer filmId);
}
