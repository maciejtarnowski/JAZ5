package domain.film;

import domain.RepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryFilmRepository implements FilmRepository {
    private List<Film> films = new ArrayList<>();

    @Override
    public List<Film> getFilms() {
        return films;
    }

    @Override
    public Film getFilmById(Integer id) {
        Optional<Film> filmById = films.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst();
        if (filmById.isPresent()) {
            return filmById.get();
        }
        return null;
    }

    @Override
    public void addFilm(Film film) {
        films.add(film);
    }

    @Override
    public void updateFilm(Integer id, String title, Integer yearOfRelease, String description) throws RepositoryException {
        Film film = getFilmById(id);
        if (film == null) {
            throw new RepositoryException("Could not update film, film not found");
        }
    }
}
