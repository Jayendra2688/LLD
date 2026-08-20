package movieticketsystem;

class Theater {
    private String theaterId;
    private String name;
    private String location;
    private City city;

    public Theater(String theaterId, String name, String location, City city) {
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
        this.city = city;   
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public City getCity() {
        return city;
    }
}
