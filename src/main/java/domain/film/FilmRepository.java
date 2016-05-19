package domain.film;

import domain.RepositoryException;

import java.util.List;

public interface FilmRepository {
    public List<Film> getFilms();
    public Film getFilmById(Integer id);
    public void addFilm(Film film);
    public void updateFilm(Integer id, String title, Integer yearOfRelease, String description) throws RepositoryException;
}
