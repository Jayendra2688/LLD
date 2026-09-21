package TicTocToe;

public class Player {
    private String name;
    private Symbol symbol;

    Player(String name,Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }
}
