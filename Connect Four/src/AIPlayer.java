public class AIPlayer implements Player
{
	private int playerID = 0;
	private int row;
	private int col;
	private char[][] gameBoard;

	public AIPlayer(int playerID, int row, int col)
	{
		this.playerID = playerID;
		this.row = row;
		this.col = col;
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

		for (int r = gameBoard.length - 1; r >= 0; r--)
		{
			for (int c = 0; c < gameBoard[r].length - 2; c++)
			{
				if (gameBoard[r][c] == '1' && gameBoard[r][c + 1] == '1' && gameBoard[r][c + 2] == ' ')
				{
					if (gameBoard[0][c + 2] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + (c + 2));
						gameBoard[r][c + 2] = '1';
						return c + 2;
					}
				} else if (c > 1 && gameBoard[r][c] == '1' && gameBoard[r][c - 1] == '1' && gameBoard[r][c - 2] == ' ')
				{
					if (gameBoard[0][c - 2] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + (c - 2));
						gameBoard[r][c - 2] = '1';
						return c - 2;
					}
				}
				// Block other players move
				else if (gameBoard[r][c] == '2' && gameBoard[r][c + 1] == '2' && gameBoard[r][c + 2] == ' ')
				{
					if (gameBoard[0][c + 2] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + (c + 2));
						gameBoard[r][c + 2] = '1';
						return c + 2;
					}
				} else if (c > 1 && gameBoard[r][c] == '2' && gameBoard[r][c - 1] == '2' && gameBoard[r][c - 2] == ' ')
				{
					if (gameBoard[0][c - 2] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + (c - 2));
						gameBoard[r][c - 2] = '1';
						return c - 2;
					}
				}
			}
		}

		for (int c = 0; c < gameBoard[0].length; c++)
		{
			for (int r = 0; r < gameBoard.length - 3; r++)
			{
				if (gameBoard[r][c] == ' ' && gameBoard[r + 1][c] == '1' && gameBoard[r + 2][c] == '1')
				{
					if (gameBoard[0][c] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + c);
						gameBoard[r][c] = '1';
						return c;
					}
				}
				// else block other players move
				if (gameBoard[r][c] == ' ' && gameBoard[r + 1][c] == '2' && gameBoard[r + 2][c] == '2')
				{
					if (gameBoard[0][c] == ' ')
					{
						System.out.println("AI " + getPlayerID() + " Chose: " + c);
						gameBoard[r][c] = '1';
						return c;
					}
				}
			}
		}

		int tokenCol = (int) (Math.random() * ((this.col - 1) + 1));
		while (tokenCol < 0 || tokenCol >= this.col || gameBoard[0][tokenCol] != ' ')
		{
			tokenCol = (int) (Math.random() * ((this.col - 1) + 1));
			System.out.println(tokenCol);
		}
		for (int r = gameBoard.length - 1; r >= 0; r--)
		{
			if (gameBoard[r][tokenCol] == ' ')
			{
				System.out.println("AI " + getPlayerID() + " Chose: " + tokenCol);
				gameBoard[r][tokenCol] = '1';
				return tokenCol;
			}
		}
		System.out.println("AI " + getPlayerID() + " chose column " + tokenCol);
		return -1;
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