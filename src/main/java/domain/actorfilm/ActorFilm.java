package domain.actorfilm;

public class ActorFilm {
    private Integer actorId;
    private Integer filmId;

    public ActorFilm() {
        super();
    }

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

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }
}
