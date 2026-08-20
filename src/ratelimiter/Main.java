package ratelimiter;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        // Create a token bucket configuration for the user's plan
        TokenBucketConfig configFree = new TokenBucketConfig(5, 10); // 5 tokens per 10 seconds
        TokenBucketConfig configPremium = new TokenBucketConfig(10, 10); // 10 tokens per 10 seconds
        TokenBucketConfig configEnterprise = new TokenBucketConfig(20, 10); // 20 tokens per 10 seconds

        // Create a rate limiter strategy (token bucket)
        RateLimiterStrategy rateLimiter = new TokenBucketStrategy();

        RateLimiterFacade rateLimiterFacade = new RateLimiterFacade(rateLimiter, Map.of(
            UserPlan.FREE, configFree,
            UserPlan.PREMIUM, configPremium,
            UserPlan.ENTERPRISE, configEnterprise
        ));

        rateLimiterFacade.registerUser("user1", UserPlan.FREE, "apiKey1");

        // Simulate requests
        for (int i = 0; i < 15; i++) {
            RateLimiterResult requestResult = rateLimiterFacade.isRequestAllowed("apiKey1");
            if (requestResult.isAllowed()) {
                System.out.println("Request " + (i + 1) + " is allowed. Remaining tokens: " + requestResult.getRemainingTokens());
            } else {
                System.out.println("Request " + (i + 1) + " is denied. Remaining tokens: " + requestResult.getRemainingTokens() + ". Wait time: " + requestResult.getResetTimeInSeconds() + " seconds.");
            }

            // Simulate a delay between requests
            try {
                Thread.sleep(500); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
