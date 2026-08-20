package splitwise;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


class Expense {
    private long id;
    private String title;
    private Instant timestamp;
    private User creditor;
    private List<User> participants;
    private BigDecimal amount;

    Expense(long id, String title,Instant timestamp,User creditor,List<User> participants,BigDecimal amount){
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.creditor = creditor;
        this.participants = participants;
        this.amount = amount;
    }
    
    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public Instant getTimestamp(){
        return timestamp;
    }

    public User getCreditor(){
        return creditor;
    }

    public List<User> getParticipants(){
        return participants;
    }

    public BigDecimal getAmount(){
        return amount;
    }


}
