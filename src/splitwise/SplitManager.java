package splitwise;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.HashMap;
public class SplitManager {
    Long userIdCounter;
    Long expenseIdCounter;
    Map<Long,User> userMap;
    List<Expense> expenseList;
    List<Balence> balenceList;
    Map<SplitType,SplitStrategy> splitStrategyMap;

    SplitManager(Map<SplitType,SplitStrategy> splitStrategyMap){
        this.splitStrategyMap = splitStrategyMap;
        this.userIdCounter = 0L;
        this.expenseIdCounter = 0L;
        userMap = new HashMap<>();
        balenceList = new ArrayList<>();
        expenseList = new ArrayList<>();
    }

    public Long addUser(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        userIdCounter++;
        User user = new User(userIdCounter,name);
        userMap.put(user.getId(),user);
        return user.getId();
    }

    public List<Balence> createExpense(String title, Long expenseCreatorId, List<Long> participantIds, BigDecimal amount, SplitType splitType) {
        SplitStrategy splitStrategy = splitStrategyMap.get(splitType);
        if (splitStrategy == null) {
            throw new IllegalArgumentException("Invalid split type: " + splitType);
        }
        if(participantIds.size() < 2){
            throw new IllegalArgumentException("Participants should be more than 1");
        }
        List<User> participants = new ArrayList<>();
        for(Long participantid : participantIds){
            User participant = userMap.get(participantid);
            if(participant.equals(null)){
                throw new IllegalArgumentException("Participant not there.");
            }else{
                participants.add(participant);
            }

        }
        Long expenseId = ++expenseIdCounter;
        User expenseCreator = userMap.get(expenseCreatorId);
        if (expenseCreator == null) {
            throw new IllegalArgumentException("Expense creator not found with ID: " + expenseCreatorId);        
        }
        //if participant list does not contain the expense creator then throw an exception
        if(!participants.contains(expenseCreator)){
            throw new IllegalArgumentException("Expense creator should be part of the participants list");
        }
        List<Balence> balences = splitStrategy.createExpense(expenseId, title, expenseCreator, participants, amount);
        // Store the balences in the balenceList or database as needed
        balenceList.addAll(balences);
        return balences;
    }

    public List<Balence> getUserDebitBalences(Long userId) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        List<Balence> userDebitBalences = new ArrayList<>();
        // Logic to retrieve all balences for the given user
        for (Balence balence : balenceList) {
            if (balence.getDebitor().getId().equals(user.getId())) {
                // Add to a list of user balences
                userDebitBalences.add(balence);
            }
        }
        // This could involve filtering the balenceList based on the user
        return userDebitBalences; // Replace with actual logic to retrieve user balences
    }

    public List<Balence> getUserCreditBalences(Long userId) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        List<Balence> userCreditBalences = new ArrayList<>();
        // Logic to retrieve all balences for the given user
        for (Balence balence : balenceList) {
            if (balence.getExpense().getCreditor().getId().equals(user.getId())) {
                // Add to a list of user balences
                userCreditBalences.add(balence);
            }
        }
        // This could involve filtering the balenceList based on the user
        return userCreditBalences; // Replace with actual logic to retrieve user balences
    }

    public Long deleteUser(Long userId) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        //check if the user has any balences associated with them
        for (Balence balence : balenceList) {
            if (balence.getDebitor().getId().equals(userId) || balence.getExpense().getCreditor().getId().equals(userId)) {
                throw new IllegalStateException("Cannot delete user with ID: " + userId + " as they have associated balences");
            }
        }
        // Logic to delete the user and associated balences
        userMap.remove(userId);
        return userId; // Return the deleted user's ID
    }
}
