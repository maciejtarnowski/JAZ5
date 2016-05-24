package domain.actorfilm;

public class ActorFilm {
    private Integer actorId;
    private Integer filmId;

    public ActorFilm(Integer actorId, Integer filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public Integer getFilmId() {
        return filmId;
    }
}
