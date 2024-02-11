package tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
	
	private final Board board;
	private final Player[] players;
	private final int noOfPlayers = 2;
	private final int noOfCell = 3;
	private int count = 0;
	private Queue<Player> playerQueue;
	private Status gameStatus;
	private Player wonPlayer;
	
	Scanner scanner;
	
	public Game(Player p1, Player p2) {
		players = new Player[noOfPlayers];
		players[0] = p1;
		players[1] = p2;
		board = new Board(noOfCell);
		playerQueue = new LinkedList<>();
		playerQueue.offer(p1);
		playerQueue.offer(p2);
		gameStatus = Status.INPROGRESS;
		scanner  = new Scanner(System.in);
		
	}
	
	public void play() {
		board.initializeBoard();
		while(gameStatus == Status.INPROGRESS) {
			board.printBoard();
			Player currentPlayer = playerQueue.poll();
			System.out.println("Player "+ currentPlayer.getPiece() + " Enter row and col:");
			
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			System.out.println();
			
			if(row >= noOfCell || col >= noOfCell ||
					row < 0 || col < 0 ||
					board.getBoxes()[row][col].getPiece() != null ) {
				
				
				System.out.println("Wrong Move Try Again");
				playerQueue.add(currentPlayer);
				playerQueue.add(playerQueue.poll());
				continue;
			}
			
			
			count++;
			
			board.getBoxes()[row][col].setPiece(currentPlayer.getPiece());
			
			checkWon(currentPlayer, row, col);
			
			checkDraw();
			
			playerQueue.add(currentPlayer);

			
		}
		board.printBoard();
		
		
	}

	private void checkDraw() {
		
		if(count == noOfCell * noOfCell) {
			gameStatus = Status.DRAW;
		}
		
	}

	private void checkWon(Player currentPlayer, int row, int col) {
		
		
		
		Cell[][] boxes = board.getBoxes();
		int rowCount = 0;
		int colCount = 0;
		int diagCount = 0;
		int revDiagCount = 0;
		for(int i = 0; i < noOfCell; i++) {
			if(boxes[row][i].getPiece() == currentPlayer.getPiece()) {
				rowCount++;
			}
			if(boxes[i][col].getPiece() == currentPlayer.getPiece()) {
				colCount++;
			}
			if(boxes[i][i].getPiece() == currentPlayer.getPiece()) {
				diagCount++;
			}
			if(boxes[i][noOfCell - 1 - i].getPiece() == currentPlayer.getPiece()) {
				revDiagCount++;
			}
		}
		if(rowCount == noOfCell || colCount == noOfCell ||  diagCount == noOfCell ||  revDiagCount == noOfCell){
			gameStatus = Status.WON;
			wonPlayer = currentPlayer;
		}	
	}

	public Status getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(Status gameStatus) {
		this.gameStatus = gameStatus;
	}

	public Player getWonPlayer() {
		return wonPlayer;
	}

	public void setWonPlayer(Player wonPlayer) {
		this.wonPlayer = wonPlayer;
	}
	
	
	

}
