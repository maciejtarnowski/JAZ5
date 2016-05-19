package domain.rating;

public class Rating {
    private Integer filmId;
    private Integer value;

    public Rating(Integer filmId, Integer value) {
        this.filmId = filmId;
        this.value = value;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
