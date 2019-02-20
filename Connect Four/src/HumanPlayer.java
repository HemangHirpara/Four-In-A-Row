public class HumanPlayer implements Player{
    
    private int playerID = 0;
    private String playerName;
    private int row;
    private int col;
    private char[][] gameBoard;
    
    public HumanPlayer(int playerID, int row, int col)
    {
        this.playerID = playerID;
        this.row = row;
        this.col = col;
        this.playerName = GIO.readString("Player"+ this.playerID + " Enter Your Name: ");
        gameBoard = new char[this.row][this.col];
        
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int k = 0; k < gameBoard[0].length; k++)
            {
                gameBoard[i][k] = ' ';
            }
        }
    }

    public void lastMove(int c) 
    {
        for (int r = gameBoard.length - 1; r >= 0; r--)
        {
            if (gameBoard[r][c] == ' ')
            {
                gameBoard[r][c] = '2';
                break;
            }
        }
    }
    
    public int playToken()
    {
        int tokenCol = GIO.readInt(this.playerName + " Choose A Column" + "\n" 
        		+"Enter -1 to End Game"+ "\n" 
        		+ "Enter -2 to Reset Game");
        if(tokenCol == -1 || tokenCol == -2) //return reset function also
        {
        	return tokenCol;
        }
        while(tokenCol >= this.col || tokenCol < 0 || gameBoard[0][tokenCol] != ' ')
        {
            tokenCol = GIO.readInt(this.playerName + " Choose Another Column");
        }
        for (int r = gameBoard.length - 1; r >= 0; r--)
        {
            if (gameBoard[r][tokenCol] == ' ')
            {
                gameBoard[r][tokenCol] = '1';
                break;
            }
        }
        return tokenCol;
    }

    public int getPlayerID()
    {
        return this.playerID;
    }
    
    public void reset()
    {
        this.playerID = 0;
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int k = 0; k < gameBoard[0].length; k++)
            {
                gameBoard[i][k] = ' ';
            }
        }
    }
}