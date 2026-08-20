package splitwise;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Splitwise!");
        Map<SplitType, SplitStrategy> splitStrategies = new HashMap<>();
        splitStrategies.put(SplitType.EQUAL, new EqualSplitStrategy());
        SplitManager splitManager = new SplitManager(splitStrategies);

        // Create users
        Long userId1 = splitManager.addUser( "Alice");
        Long userId2 = splitManager.addUser( "Bob");
        Long userId3 =  splitManager.addUser( "Charlie");

        // Create an expense
        List<Long> participantIds = new ArrayList<>();
        participantIds.add(userId1);
        participantIds.add(userId2);
        participantIds.add(userId3);
        BigDecimal amount = new BigDecimal("150.00");
        List<Balence> balences = splitManager.createExpense( "Dinner", userId1, participantIds, amount, SplitType.EQUAL);

        // Display the balances for each user
        for (Long participantid : participantIds) {
            List<Balence> userDebitBalences = splitManager.getUserDebitBalences(participantid);
            if (userDebitBalences.isEmpty()) {
                System.out.println("No balances for user with ID: " + participantid);
                continue;
            }
            System.out.println("Balances for " + userDebitBalences.get(0).getDebitor().getName() + ":");
            for (Balence balence : userDebitBalences) {
                System.out.println("Owes " + balence.getExpense().getCreditor().getName() + ": " + balence.getDebitAmount());
            }
            System.out.println();
        }

    }
}
