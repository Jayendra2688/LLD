package splitwise;
import java.math.BigDecimal;
public class Balence {
    private Expense expense;
    private User debitor;
    private BigDecimal debitAmount;

    Balence(Expense expense, User debitor, BigDecimal debitAmount){
        this.expense = expense;
        this.debitor = debitor;
        this.debitAmount = debitAmount;
    }

    public Expense getExpense(){
        return expense;
    }
    public User getDebitor(){
        return debitor;
    }
    public BigDecimal getDebitAmount(){
        return debitAmount;
    }
}
