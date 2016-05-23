package domain.film;

import domain.RepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryFilmRepository implements FilmRepository {
    private static List<Film> films = new ArrayList<>();
    private static Integer currentId = 0;

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
        film.setId(++currentId);
        films.add(film);
    }

    @Override
    public Film updateFilm(Film film) throws RepositoryException {
        Film updatedFilm = getFilmById(film.getId());
        if (updatedFilm == null) {
            throw new RepositoryException("Could not update film, film not found");
        }

        if (film.getDescription() != null) {
            updatedFilm.setDescription(film.getDescription());
        }
        if (film.getTitle() != null) {
            updatedFilm.setTitle(film.getTitle());
        }
        if (film.getYearOfRelease() != null) {
            updatedFilm.setYearOfRelease(film.getYearOfRelease());
        }

        return updatedFilm;
    }
}
