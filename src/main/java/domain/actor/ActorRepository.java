package domain.actor;

import java.util.List;

public interface ActorRepository {
    void addActor(Actor actor);
    Actor getActorById(Integer id);
}
