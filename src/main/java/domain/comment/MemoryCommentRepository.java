package domain.comment;

import domain.RepositoryException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MemoryCommentRepository implements CommentRepository {
    private List<Comment> comments = new ArrayList<>();

    @Override
    public void addComment(Comment comment) {
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
