public class SOSGame{
    public enum GameMode{SIMPLE, GENERAL}
    private char [][] board;
    private int boardSize;
    private GameMode mode;
    private boolean isPlayer1Turn;

    public SOSGame(int boardSize, GameMode mode){
        this.boardSize = boardSize;
        this.mode = mode;
        board = new char[boardSize][boardSize];
        isPlayer1Turn = true;
        initializeBoard();
       
    }

    private void initializeBoard(){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = ' ';
            }
        }
    }
    
    public boolean move(int row, int col, char letter){
        if(row < 0 || row >= boardSize || col < 0 || col >= boardSize || board[row][col] != ' '){
            board[row][col] = letter;
            togglePlayer();
            return true;
            
        }
        return false;
    }

    private void togglePlayer(){
        isPlayer1Turn = !isPlayer1Turn;
    }

    public boolean isPlayer1Turn(){
        return isPlayer1Turn;
    }

    public char[][] getBoard(){
        return board;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public GameMode getGameMode(){
        return mode;
    }
  

}
