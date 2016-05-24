package domain.actor;

import java.util.List;

public interface ActorRepository {
    void addActor(Actor actor);
    void assignActorToFilm(Integer actorId, Integer filmId);
}
