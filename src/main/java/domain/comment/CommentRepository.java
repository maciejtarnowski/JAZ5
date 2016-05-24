package domain.comment;

import domain.RepositoryException;
import domain.film.Film;

import java.util.List;

public interface CommentRepository {
    void addComment(Comment comment);
    void deleteCommentById(Integer id) throws RepositoryException;
    List<Comment> getCommentsForFilm(Integer filmId);
}
