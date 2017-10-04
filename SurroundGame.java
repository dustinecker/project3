package surroundpack;

public class SurroundGame {

	/** Initializes a 2D array of Cells to determine player location */
	private Cell[][] board;

	/** Player int used to determine whose turn it is */
	private int player;

	/** Stores the number of players for this game */
	private int numPlayers;

	/** Int that stores board size */
	private int boardSize;

	/******************************************************************
	 * Default constructor that instantiates each object.
	 * @param boardSize Passes in the desired board size from the user.
	 * @param numPlayers Passes in the desired number of players from
	 * the user.
	 * @param startingPlayer Passes in which player the user wnats to
	 * start first.
	 *****************************************************************/
	public SurroundGame(int boardSize, int numPlayers, 
			int startingPlayer) {
		this.boardSize = boardSize;
		this.numPlayers = numPlayers - 1;
		player = startingPlayer;

		board = new Cell[boardSize][boardSize];

		for(int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {
				board[row][col] = new Cell(-1);
			}
		}
	}

	/******************************************************************
	 * Returns the current player to determine whose turn it is.
	 *****************************************************************/
	public int getPlayer() {
		return player;
	}

	/******************************************************************
	 * Sets the clicked cell to the current players number.
	 * @param row Tells what row of cells to set player number to.
	 * @param col Tell what column of cells to set player number to.
	 *****************************************************************/
	public void setCell(int row, int col) {
		board[row][col].setPlayerNumber(player);
	}

	/******************************************************************
	 * Used to determine if selected button is occupied.
	 * @param Checks board at given row.
	 * @param Checks board at given column.
	 *****************************************************************/
	public Boolean select(int row, int col) {
		boolean bool;

		if(board[row][col].getPlayerNumber() == -1) {
			bool = true;
		}
		else {
			bool = false;
		}

		return bool;
	}

	/******************************************************************
	 * Resets the board to a new game.
	 *****************************************************************/
	public void reset() {
		board = new Cell[boardSize][boardSize];

		for(int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {
				board[row][col] = new Cell(-1);
			}
		}
	}

	/******************************************************************
	 * Used to get the player number of the occupied cell.
	 * @param Checks board at given row.
	 * @param Checks board at given column.
	 *****************************************************************/
	public int getPlayerNumber(int row, int col) {
		int playerNumber = board[row][col].getPlayerNumber();

		return playerNumber;
	}

	/******************************************************************
	 * Called after player has chosen a cell to switch to the next
	 * player.
	 *****************************************************************/
	public void nextPlayer() {
		player += 1;

		if(player > numPlayers) {
			player = 0;
		}
	}

	/******************************************************************
	 * Called to determine if there is a winner.
	 *****************************************************************/
	public int isWinner() {
		int winner = -1;

		for(int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {

				if(board[row][col].getPlayerNumber() != -1) {
					if(checkNorth(row, col) == 0 && 
							checkSouth(row, col) == 0 && 
							checkEast(row, col) == 0 && 
							checkWest(row, col) == 0 &&
							board[row][col].getPlayerNumber() != 0) {
						winner = 0;
					}
					else if(checkNorth(row, col) == 1 && 
							checkSouth(row, col) == 1 && 
							checkEast(row, col) == 1 && 
							checkWest(row, col) == 1 &&
							board[row][col].getPlayerNumber() != 1) {
						winner = 1;
					}
					else if(checkNorth(row, col) == 2 && 
							checkSouth(row, col) == 2 && 
							checkEast(row, col) == 2 && 
							checkWest(row, col) == 2 &&
							board[row][col].getPlayerNumber() != 2) {
						winner = 2;
					}
					else if(checkNorth(row, col) == 3 && 
							checkSouth(row, col) == 3 && 
							checkEast(row, col) == 3 && 
							checkWest(row, col) == 3 &&
							board[row][col].getPlayerNumber() != 3) {
						winner = 3;
					}
					else if(checkNorth(row, col) == 4 && 
							checkSouth(row, col) == 4 && 
							checkEast(row, col) == 4 && 
							checkWest(row, col) == 4 &&
							board[row][col].getPlayerNumber() != 4) {
						winner = 4;
					}
				}
			}
		}

		return winner;
	}

	/******************************************************************
	 * Private helper method for checkIfWinner method that checks the
	 * North cell.
	 * @param row Passes in row of the cell we're checking for a winner
	 * at.
	 * @param col Passes in column of the cell we're checking or a 
	 * winner at.
	 *****************************************************************/
	private int checkNorth(int row, int col) {
		if(col == 0) {
			col = boardSize - 1;
		}
		else {
			col -= 1;
		}

		return board[row][col].getPlayerNumber();
	}

	/******************************************************************
	 * Private helper method for checkIfWinner method that checks the
	 * South cell.
	 * @param row Passes in row of the cell we're checking for a winner
	 * at.
	 * @param col Passes in column of the cell we're checking or a 
	 * winner at.
	 *****************************************************************/
	private int checkSouth(int row, int col) {
		if(col == boardSize - 1) {
			col = 0;
		}
		else {
			col += 1;
		}

		return board[row][col].getPlayerNumber();
	}

	/******************************************************************
	 * Private helper method for checkIfWinner method that checks the
	 * East cell.
	 * @param row Passes in row of the cell we're checking for a winner
	 * at.
	 * @param col Passes in column of the cell we're checking or a 
	 * winner at.
	 *****************************************************************/
	private int checkEast(int row, int col) {
		if(row == boardSize - 1) {
			row = 0;
		}
		else {
			row += 1;
		}

		return board[row][col].getPlayerNumber();
	}

	/******************************************************************
	 * Private helper method for checkIfWinner method that checks the
	 * West cell.
	 * @param row Passes in row of the cell we're checking for a winner
	 * at.
	 * @param col Passes in column of the cell we're checking or a 
	 * winner at.
	 *****************************************************************/
	private int checkWest(int row, int col) {
		if(row == 0) {
			row = boardSize - 1;
		}
		else {
			row -= 1;
		}

		return board[row][col].getPlayerNumber();
	}
}
