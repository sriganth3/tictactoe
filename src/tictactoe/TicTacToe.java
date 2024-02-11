package tictactoe;

public class TicTacToe {

	public static void main(String[] args) {
		
		Player player1 = new Player("SG","123",Piece.X);
		Player player2 = new Player("JR","234",Piece.O);
		
		Game game = new Game(player1, player2);
		game.play();
		if(game.getGameStatus() == Status.DRAW) {
			System.out.println("Match Draw");
		}else {
			System.out.println("Player: " + game.getWonPlayer().getUserName() + " won");
		}
	}

}
