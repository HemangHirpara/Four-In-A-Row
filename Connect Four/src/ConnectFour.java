public class ConnectFour
{

	public static void main(String[] args)
	{

		// Create new board object
		Board b = new Board();
		// Set player tokens for player 1 and player 2
		b.setPlayerOne('o');
		b.setPlayerTwo('t');
		// Create Player objects

		// Note, the code below works because of the interface Player. All
		// classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really
		// easy. For a challenge, you might
		// consider:
		// 1. asking the user whether he/she wants to play against a human or a
		// computer
		// 2. implementing multiple AI players (easy, med, hard) that the user
		// can choose to play against
		Player p1;
		Player p2;
		//Player p1 = new HumanPlayer(1, 6, 7);
		//Player p2 = new HumanPlayer(2, 6, 7); // comment this line when
		// testing
		// AIPlayer
		// Player p1 = new AIPlayer(1, 6, 7);
		// Player p2 = new AIPlayer(2, 6, 7);
		// uncomment this line when testing AIPlayer
		Boolean ask = GIO.readBoolean("Do you want to play against the computer?");
		if(ask == true)
		{
			ask = GIO.readBoolean("Do you want to go first?");
			if(ask == true)
			{
				p1 =  new HumanPlayer(1, 6, 7);
				p2 = new AIPlayer(2, 6, 7);
			}
			else
			{
				p1 = new AIPlayer(1, 6, 7);
				p2 =  new HumanPlayer(2, 6, 7);
			}
		}
		else
		{
			p1 =  new HumanPlayer(1, 6, 7);
			p2 =  new HumanPlayer(2, 6, 7);
		}

		int c;
		CFGUI cfBoard = new CFGUI(b, ChipColor.RED, ChipColor.BLUE);
		while (b.isFinished() != 1 || b.isFinished() != 2 || b.isFinished() == -1)
		{
			c = p1.playToken();
			//Check End Game/Reset Game
			while (c == -1 || c == -2)
			{
				if (c == -1)
				{
					Boolean output = GIO.readBoolean("End Game?");
					if (output == true)
					{
						cfBoard.close();
						return;
					} else
						c = p1.playToken();
				}
				if (c == -2)
				{
					GIO.displayMessage("Resetting Game...");
					cfBoard.reset(b, p1, p2);
					cfBoard.redraw();
					
					Boolean askAgain = GIO.readBoolean("Do you want to play against the computer again?");
					if(askAgain == true)
					{
						p1 =  new HumanPlayer(1, 6, 7);
						p2 = new AIPlayer(2, 6, 7);
					}
					else
					{
						p1 =  new HumanPlayer(1, 6, 7);
						p2 =  new HumanPlayer(2, 6, 7);
					}
					
					c = p1.playToken();
				}

			}
			b.play(p1.getPlayerID(), c);
			cfBoard.redraw();
			p2.lastMove(c);
			//Check Win Condition
			if (b.isFinished() == 1)
			{
				cfBoard.gameOver((b.isFinished()));
				cfBoard.close();
				break;
			} else if (b.isFinished() == 2)
			{
				cfBoard.gameOver((b.isFinished()));
				cfBoard.close();
				break;
			}
			c = p2.playToken();
			//Check End Game/Reset Game
			while (c == -1 || c == -2)
			{
				if (c == -1)
				{
					Boolean output = GIO.readBoolean("End Game?");
					if (output == true)
					{
						cfBoard.close();
						return;
					} else
						c = p2.playToken();
				}
				if (c == -2)
				{
					GIO.displayMessage("Resetting Game...");
					cfBoard.reset(b, p1, p2);
					cfBoard.redraw();
					
					Boolean askAgain = GIO.readBoolean("Do you want to play against the computer again?");
					if(askAgain == true)
					{
						p1 =  new HumanPlayer(1, 6, 7);
						p2 = new AIPlayer(2, 6, 7);
					}
					else
					{
						p1 =  new HumanPlayer(1, 6, 7);
						p2 =  new HumanPlayer(2, 6, 7);
					}
					c = p2.playToken();
				}

			}
			b.play(p2.getPlayerID(), c);
			cfBoard.redraw();
			p1.lastMove(c);
			//Check Win Condition
			if (b.isFinished() == 1)
			{
				cfBoard.gameOver((b.isFinished()));
				cfBoard.close();
				break;
			} else if (b.isFinished() == 2)
			{
				cfBoard.gameOver((b.isFinished()));
				cfBoard.close();
				break;
			}
		}
	}
}