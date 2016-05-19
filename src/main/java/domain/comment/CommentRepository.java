package domain.comment;

import domain.RepositoryException;

public interface CommentRepository {
    public void addComment(Comment comment);
    public void deleteCommentById(Integer id) throws RepositoryException;
}
