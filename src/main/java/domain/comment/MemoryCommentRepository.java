package domain.comment;

import domain.RepositoryException;
import domain.film.Film;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryCommentRepository implements CommentRepository {
    private static List<Comment> comments = new ArrayList<>();
    private static Integer currentId = 0;

    @Override
    public void addComment(Comment comment) {
        comment.setId(++currentId);
        comments.add(comment);
    }

    @Override
    public void deleteCommentById(Integer id) throws RepositoryException {
        if (getCommentById(id) == null) {
            throw new RepositoryException("Comment not found");
        }
        for (Iterator<Comment> i = comments.iterator(); i.hasNext();) {
            Comment comment = i.next();
            if (comment.getId().equals(id)) {
                i.remove();
            }
        }
    }

    @Override
    public List<Comment> getCommentsForFilm(Integer filmId) {
        return comments.stream()
                .filter(comment -> comment.getFilmId().equals(filmId))
                .collect(Collectors.toList());
    }

    private Comment getCommentById(Integer id) {
        Optional<Comment> commentById = comments.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst();
        if (commentById.isPresent()) {
            return commentById.get();
        }
        return null;
    }
}
