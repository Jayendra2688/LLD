package splitwise;
import java.math.BigDecimal;
import java.util.List;
import java.time.Instant;
import java.util.ArrayList;
class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Balence> createExpense(long id,String title, User expenseCreator, List<User> participants, BigDecimal amount) {
        List<Balence> balences = new ArrayList<>();
        //create a new expense object
        Expense expense = new Expense(id, title, Instant.now(), expenseCreator, participants, amount);
        // Logic to create an equal split expense
        BigDecimal debitAmount = amount.divide(new BigDecimal(participants.size()));
        for(User participant : participants){
            if(participant.getId() != expenseCreator.getId()){
                Balence balence = new Balence(expense, participant, debitAmount);
                // Store the balence object in a list or database as needed
                balences.add(balence);
            }
        }

        // For simplicity, let's assume we just return a dummy expense ID
        return balences; // Replace with actual logic to create and store the expense
    }
}
