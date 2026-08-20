package splitwise;
import java.math.BigDecimal;
import java.util.List;

public interface SplitStrategy {
    List<Balence> createExpense(long id,String title, User expenseCreator, List<User> participants, BigDecimal amount);
}
