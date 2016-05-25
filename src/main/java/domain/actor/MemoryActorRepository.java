package domain.actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryActorRepository implements ActorRepository {
    private static List<Actor> actors = new ArrayList<>();
    private Integer currentId = 0;

    @Override
    public void addActor(Actor actor) {
        actor.setId(++currentId);
        actors.add(actor);
    }

    @Override
    public Actor getActorById(Integer id) {
        Optional<Actor> optionalActor = actors.stream()
                .filter(actor -> actor.getId().equals(id))
                .findFirst();
        if (optionalActor.isPresent()) {
            return optionalActor.get();
        }
        return null;
    }
}
