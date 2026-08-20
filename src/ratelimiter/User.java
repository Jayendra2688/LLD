package ratelimiter;

public class User {
    private String id;
    private UserPlan plan;

    public User(String id, UserPlan plan) {
        this.id = id;
        this.plan = plan;
    }

    public String getId() {
        return id;
    }

    public UserPlan getPlan() {
        return plan;
    }
}
