package splitwise;

class User{
    private Long id;
    private String name;

    User(Long id,String name){
        this.id = id;
        this.name = name;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}