package ratelimiter;

public class TokenBucketConfig {
    private int tokenBucketCapacity;
    private int timeWindowInSeconds;

    public TokenBucketConfig(int tokenBucketCapacity, int timeWindowInSeconds) {
        this.tokenBucketCapacity = tokenBucketCapacity;
        this.timeWindowInSeconds = timeWindowInSeconds;
    }

    public int getTokenBucketCapacity() {
        return tokenBucketCapacity;
    }

    public int getTimeWindowInSeconds() {
        return timeWindowInSeconds;
    }
}
