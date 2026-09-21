package TicTocToe;

public class Symbol {
    private char ch;
    private Color color;
    Symbol(char ch,Color color){
        this.ch = ch;
        this.color = color;
    }
    public char getSymbol(){
        return this.ch;
    }
}
