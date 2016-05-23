package domain.film;

import domain.RepositoryException;

import java.util.List;

public interface FilmRepository {
    List<Film> getFilms();
    Film getFilmById(Integer id);
    void addFilm(Film film);
    Film updateFilm(Film film) throws RepositoryException;
}
