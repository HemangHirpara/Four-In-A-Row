public class Board
{
	private char[][] gameBoard;
	private int row;
	private int col;
	private char o = 'o';
	private char t = 't';
	private int player1 = 1;
	private int player2 = 2;

	public Board()
	{
		this.row = 6;
		this.col = 7;
		this.gameBoard = new char[this.row][this.col];

		for (int i = 0; i < gameBoard.length; i++)
		{
			for (int k = 0; k < gameBoard[0].length; k++)
			{
				gameBoard[i][k] = ' ';
			}
		}
	}

	public Board(int row, int col)
	{
		if (row < 0 || col < 0)
		{
			this.row = 6;
			this.col = 7;
		} else
		{
			this.row = row;
			this.col = col;
		}
		this.gameBoard = new char[this.row][this.col];

		for (int i = 0; i < gameBoard.length; i++)
		{
			for (int k = 0; k < gameBoard[0].length; k++)
			{
				gameBoard[i][k] = ' ';
			}
		}
	}

	public int getNumRows()
	{
		return this.row;
	}

	public int getNumCols()
	{
		return this.col;
	}

	public char getPlayerOne()
	{
		return this.o;
	}

	public char getPlayerTwo()
	{
		return this.t;
	}

	public void setPlayerOne(char o)
	{
		this.o = o;
	}

	public void setPlayerTwo(char t)
	{
		this.t = t;
	}

	public char getToken(int row, int col)
	{
		if (row < 0 || row >= this.row || col < 0 || col >= this.col)
			return '\0';
		else
			return gameBoard[row][col];
	}

	public boolean canPlay()
	{
		for (int i = 0; i < gameBoard.length; i++)
		{
			for (int k = 0; k < gameBoard[i].length; k++)
			{
				if (gameBoard[i][k] == ' ')
				{
					return true;
				}
			}
		}
		return false;
	}

	public boolean play(int p, int c)
	{
		char token = ' ';
		if (p == this.player1)
		{
			
			token = this.o;
		}
		else if (p == this.player2)
		{
			
			token = this.t;
		}
		else
			token = 'x';

		if ((p == this.player1 || p == this.player2) && c >= 0 && c < getNumCols())
		{
			for (int r = gameBoard.length - 1; r >= 0; r--)
			{
				if (gameBoard[r][c] == ' ')
				{
					gameBoard[r][c] = token;
					return true;
				}
			}
			return false;
		} else
			return false;
	}

	public int checkHorizontal()
	{

		for (int r = gameBoard.length - 1; r >= 0; r--)
		{
			for (int c = 0; c < gameBoard[0].length - 3; c++)
			{
				if (gameBoard[r][c] == this.o && gameBoard[r][c + 1] == this.o && gameBoard[r][c + 2] == this.o
						&& gameBoard[r][c + 3] == this.o)
				{
					return player1;
				}
				if (gameBoard[r][c] == this.t && gameBoard[r][c + 1] == this.t && gameBoard[r][c + 2] == this.t
						&& gameBoard[r][c + 3] == this.t)
				{
					return player2;
				}
			}
		}
		return 0;
	}

	public int checkVertical()
	{
		for (int c = 0; c < gameBoard[0].length; c++)
		{
			for (int r = 0; r < gameBoard.length - 3; r++)
			{
				if (gameBoard[r][c] == this.o && gameBoard[r + 1][c] == this.o && gameBoard[r + 2][c] == this.o
						&& gameBoard[r + 3][c] == this.o)
				{
					return player1;
				}
				if (gameBoard[r][c] == this.t && gameBoard[r + 1][c] == this.t && gameBoard[r + 2][c] == this.t
						&& gameBoard[r + 3][c] == this.t)
				{
					return player2;
				}
			}
		}
		return 0;
	}

	public int checkDiagonal()
	{
		for (int r = 0; r < gameBoard.length - 3; r++)
		{
			for (int c = 0; c < gameBoard[r].length - 3; c++)
			{
				if (gameBoard[r][c] == this.o && gameBoard[r + 1][c + 1] == this.o && gameBoard[r + 2][c + 2] == this.o
						&& gameBoard[r + 3][c + 3] == this.o)
				{
					return player1;
				} else if (gameBoard[r][c] == this.t && gameBoard[r + 1][c + 1] == this.t
						&& gameBoard[r + 2][c + 2] == this.t && gameBoard[r + 3][c + 3] == this.t)
				{
					return player2;
				}
			}
		}
		for (int r = 0; r < gameBoard.length - 3; r++)
		{
			for (int c = gameBoard[r].length - 1; c >= 3; c--)
			{
				if (gameBoard[r][c] == this.o && gameBoard[r + 1][c - 1] == this.o && gameBoard[r + 2][c - 2] == this.o
						&& gameBoard[r + 3][c - 3] == this.o)
				{
					return 1;
				} else if (gameBoard[r][c] == this.t && gameBoard[r + 1][c - 1] == this.t
						&& gameBoard[r + 2][c - 2] == this.t && gameBoard[r + 3][c - 3] == this.t)
				{
					return 2;
				}
			}
		}
		return 0;
	}

	public void printBoard()
	{
		for (int r = 0; r < gameBoard.length; r++)
		{
			for (int c = 0; c < gameBoard[0].length; c++)
			{
				System.out.print("|" + gameBoard[r][c] + "|" + "\t");
			}
			System.out.println();
		}
		System.out.println("0" + "\t" + "1" + "\t" + "2" + "\t" + "3"+ "\t" + "4" + "\t" + "5" + "\t" + "6");
	}

	public void reset()
	{
		for (int i = 0; i < gameBoard.length; i++)
        {
            for (int k = 0; k < gameBoard[0].length; k++)
            {
                gameBoard[i][k] = ' ';
            }
        }
	}
	public int isFinished()
	{
		if (!canPlay() && checkHorizontal() == 0 && checkVertical() == 0 && checkDiagonal() == 0)
			return 0;
		else if (checkHorizontal() == player1 || checkVertical() == player1 || checkDiagonal() == player1)
			return this.player1;
		else if (checkHorizontal() == player2 || checkVertical() == player2 || checkDiagonal() == player2)
			return this.player2;
		else
			return -1;
	}
}
