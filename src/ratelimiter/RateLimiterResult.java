package ratelimiter;

class RateLimiterResult{
    private boolean isAllowed;
    private int remainingTokens;
    private long resetTimeInSeconds;
    
    public RateLimiterResult(boolean isAllowed, int remainingTokens, long resetTimeInSeconds) {
        this.isAllowed = isAllowed;
        this.remainingTokens = remainingTokens;
        this.resetTimeInSeconds = resetTimeInSeconds;
    }

    public boolean isAllowed() {
        return isAllowed;
    }
    
    public int getRemainingTokens() {
        return remainingTokens;
    }

    public long getResetTimeInSeconds() {
        return resetTimeInSeconds;
    }
}
