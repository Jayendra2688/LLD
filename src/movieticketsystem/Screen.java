package movieticketsystem;

class Screen {
    private String screenId;
    private String name;
    private int totalSeats;
    private Theater theater;

    public Screen(String screenId, String name, int totalSeats, Theater theater) {
        this.screenId = screenId;
        this.name = name;
        this.totalSeats = totalSeats;
        this.theater = theater;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getName() {
        return name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }    

    public Theater getTheater() {
        return theater;
    }
}
