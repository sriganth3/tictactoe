package tictactoe;

public class Player {

	private String userId;
	private String userName;
	private Piece piece;
	
	public Player(String userName, String userId, Piece piece) {
		this.userId = userId;
		this.userName = userName;
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}
