package domain.rating;

public class RatingSummary {
    private Double average;
    private Integer votesCount;

    public RatingSummary(Double average, Integer votesCount) {
        this.average = average;
        this.votesCount = votesCount;
    }

    public Double getAverage() {
        return average;
    }

    public Integer getVotesCount() {
        return votesCount;
    }
}
