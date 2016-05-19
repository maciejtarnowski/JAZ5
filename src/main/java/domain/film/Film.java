package domain.film;

public class Film {
    private Integer id;
    private String title;
    private Integer yearOfRelease;
    private String description;

    public Film(Integer id, String title, Integer yearOfRelease, String description) {
        this.id = id;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
