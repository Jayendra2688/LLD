package ratelimiter;
import java.time.Instant;
public class ApiKey {
    private String key;
    private User user;
    private boolean isActive;
    private TokenBucketState state;

    public ApiKey(String key, User user,double initialTokens) {
        this.key = key;
        this.user = user;
        this.isActive = true; // By default, the API key is active when created
        this.state = new TokenBucketState(initialTokens, Instant.now()); // Initialize with specified tokens and current time
    }

    public String getKey() {
        return key;
    }

    public User getUser() {
        return user;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

    public TokenBucketState getState() {
        return state;
    }
}
