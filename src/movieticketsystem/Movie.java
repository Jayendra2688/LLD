package movieticketsystem;

class Movie {
    private String movieId;
    private String name;
    private Long durationInMinutes;

    public Movie(String movieId, String name, Long durationInMinutes) {
        this.movieId = movieId;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
    }

    public String getName() {
        return name;
    }

    public String getMovieId() {
        return movieId;
    }

    public Long getDurationInMinutes() {
        return durationInMinutes;
    }
}
