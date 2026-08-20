package ratelimiter;

interface RateLimiterStrategy {
    public RateLimiterResult isRequestAllowed(TokenBucketConfig config,TokenBucketState state);
}
