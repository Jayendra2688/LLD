package ratelimiter;
import java.time.Instant;
class TokenBucketStrategy implements RateLimiterStrategy {
    @Override
    public RateLimiterResult isRequestAllowed(TokenBucketConfig config, TokenBucketState state) {
        long currentTime = System.currentTimeMillis();
        double timeElapsed = (currentTime - state.getLastRefillTime().toEpochMilli()) / 1000.0; // Convert to seconds
        double rate = (double) config.getTokenBucketCapacity() / config.getTimeWindowInSeconds();

        // Refill tokens based on the time elapsed
        double tokensToAdd = timeElapsed * rate;
        if(tokensToAdd > 0) {
            double newTokenCount = Math.min(state.getTokens() + tokensToAdd, config.getTokenBucketCapacity());
            state.setLastRefillTime(Instant.ofEpochMilli(currentTime));
            state.setTokens(newTokenCount);
        }
                
        // Check if there are enough tokens for the request
        if (state.getTokens() >= 1) {
            state.setTokens(state.getTokens() - 1); // Consume a token
            return new RateLimiterResult(true, (int) state.getTokens(), 0); // Request is allowed
        } else {
            int waitTime = (int) Math.ceil((1 - state.getTokens()) / rate); // Calculate wait time in seconds
            return new RateLimiterResult(false, (int) state.getTokens(), waitTime); // Request is denied
        }
    }
    
}
