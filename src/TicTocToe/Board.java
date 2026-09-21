package TicTocToe;

public class Board {
    Symbol[][] board;
    Player player1;
    Player player2;

    Board(Player player1,Player player2){
        board = new Symbol[3][3];
        this.player1 = player1;
        this.player2 = player2;
    }

    public void printBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].getSymbol() + "  |");
                else{
                    System.out.print("_" + "  |");
                }
            }
            System.out.print("\n");
        }
    }
    public boolean putSymbol(int i,int j,Symbol sym){
        if(board[i][j]!=null){
            board[i][j] = sym;
            return  true;
        }
        return  false;
    }
    public Player checkWinner(){
        for(int i=0;i<3;i++){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int j=0;j<3;j++){
                if(board[i][j]!=null){
                    if(board[i][j]==player1.getSymbol()){
                        cnt1+=1;
                    }else{
                        cnt2+=1;
                    }
                }
            }
            if(cnt1==3) return player1;
            if(cnt2==3) return player2;
        }
        for(int j=0;j<3;j++){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int i=0;i<3;i++){
                if(board[i][j]!=null){
                    if(board[i][j]==player1.getSymbol()){
                        cnt1+=1;
                    }else{
                        cnt2+=1;
                    }
                }
            }
            if(cnt1==3) return player1;
            if(cnt2==3) return player2;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int x=0;x<3;x++){
            if(board[x][x]!=null){
                if(board[x][x]==player1.getSymbol()){
                    cnt1+=1;
                }else{
                    cnt2+=1;
                }
            }
        }
        
        if(cnt1==3) return player1;
        if(cnt2==3) return player2;
        cnt1 = 0;
        cnt2 = 0;
        for(int x=0;x<3;x++){
            if(board[2-x][x]!=null){
                if(board[2-x][x]==player1.getSymbol()){
                    cnt1+=1;
                }else{
                    cnt2+=1;
                }
            }
        }
        if(cnt1==3) return player1;
        if(cnt2==3) return player2;
        return  null;
    }
}
