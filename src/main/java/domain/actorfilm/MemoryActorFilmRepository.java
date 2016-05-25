package domain.actorfilm;

import domain.actor.Actor;
import domain.actor.ActorRepository;
import domain.film.Film;
import domain.film.FilmRepository;
import rest.RepositoryRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryActorFilmRepository implements ActorFilmRepository {
    private static List<ActorFilm> actorFilms = new ArrayList<>();

    @Override
    public List<Film> getFilmsByActor(Integer actorId) {
        FilmRepository filmRepository = RepositoryRegistry.getFilmRepository();

        return actorFilms.stream()
                .filter(actorFilm -> actorFilm.getActorId().equals(actorId))
                .map(actorFilm -> filmRepository.getFilmById(actorFilm.getFilmId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorsByFilm(Integer filmId) {
        ActorRepository actorRepository = RepositoryRegistry.getActorRepository();

        return actorFilms.stream()
                .filter(actorFilm -> actorFilm.getFilmId().equals(filmId))
                .map(actorFilm -> actorRepository.getActorById(actorFilm.getActorId()))
                .collect(Collectors.toList());
    }

    @Override
    public void assignActorToFilm(Integer actorId, Integer filmId) {
        actorFilms.add(new ActorFilm(actorId, filmId));
    }
}
