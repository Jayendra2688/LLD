package movieticketsystem;

class City {
    private String cityId;
    private String name;
    private String location; // Optional: You can add more attributes like location, state, etc.    

    public City(String cityId, String name, String location) {
        this.cityId = cityId;
        this.name = name;
        this.location = location;
    }
    public City(String cityId, String name) {
        this.cityId = cityId;
        this.name = name;
        this.location = null; // Default value if location is not provided
    }
    public String getName() {
        return name;
    }
    public String getCityId() {
        return cityId;
    }
    public String getLocation() {
        return location;
    }
}
