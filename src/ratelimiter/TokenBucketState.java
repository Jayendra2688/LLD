package ratelimiter;
import java.time.Instant;
public class TokenBucketState {

    //contains tokens and last request time and it belongs to api key
    private double tokens;
    private Instant lastRefillTime;

    
    public TokenBucketState(double tokens, Instant lastRefillTime) {
        this.tokens = tokens;
        this.lastRefillTime = lastRefillTime;
    }

    public double getTokens() {
        return tokens;
    }

    public void setTokens(double tokens) {
        this.tokens = tokens;
    }

    public Instant getLastRefillTime() {
        return lastRefillTime;
    }

    public void setLastRefillTime(Instant lastRefillTime) {
        this.lastRefillTime = lastRefillTime;
    }
    
}
