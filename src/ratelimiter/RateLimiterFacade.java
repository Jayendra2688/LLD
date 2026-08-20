package ratelimiter;

import java.util.Map;

class RateLimiterFacade {
    // a map between api key and user 
    private Map<String, User> userMap;
    private Map<String, ApiKey> apiKeyMap;
    private RateLimiterStrategy rateLimiterstrategy;
    private Map<UserPlan, TokenBucketConfig> planConfigMap;

    public RateLimiterFacade(RateLimiterStrategy rateLimiterstrategy, Map<UserPlan, TokenBucketConfig> planConfigMap) {
        this.userMap = new java.util.HashMap<>();
        this.apiKeyMap = new java.util.HashMap<>();
        this.rateLimiterstrategy = rateLimiterstrategy;
        this.planConfigMap = planConfigMap;
    }

    public RateLimiterResult isRequestAllowed(String apiKey) {
        ApiKey key = apiKeyMap.get(apiKey);
        if(key == null || !key.isActive()) {
            return new RateLimiterResult(false, 0, 0); // API key is invalid or inactive
        }
        User user = key.getUser();
        if(user == null) {
            return new RateLimiterResult(false, 0, 0); // User not found for the given API key
        }   
        UserPlan plan = user.getPlan();
        TokenBucketConfig config = planConfigMap.get(plan);
        if(config == null) {
            return new RateLimiterResult(false, 0, 0); // No configuration found for the user's plan
        }
        TokenBucketState state = key.getState();
        RateLimiterResult result = rateLimiterstrategy.isRequestAllowed(config, state);
        return result;
    }

    public void registerUser(String userName, UserPlan plan, String apiKey) {
        if(userMap.containsKey(userName)) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = new User(userName, plan);
        userMap.put(userName, user);
        
        //get the initial tokens for the user plan
        TokenBucketConfig config = planConfigMap.get(plan);
        if(config == null) {
            throw new IllegalArgumentException("No configuration found for the user's plan");
        }
        ApiKey key = new ApiKey(apiKey, user, config.getTokenBucketCapacity());
        apiKeyMap.put(apiKey, key);
    }

    public void deactivateApiKey(String apiKey) {
        ApiKey key = apiKeyMap.get(apiKey);
        if(key != null) {
            key.deactivate();
        }
    }
}