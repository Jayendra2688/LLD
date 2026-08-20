package movieticketsystem;

class User {
    private String id;
    private String name;

    //constructor
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
}
