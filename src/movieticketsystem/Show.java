package movieticketsystem;

class Show {
    private String showId;
    private Movie movie;
    private Screen screen;
    private String startTime;
    private String endTime;

    public Show(String showId, Movie movie, Screen screen, String startTime, String endTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }    

    public Screen getScreen() {
        return screen;
    }
    
}
