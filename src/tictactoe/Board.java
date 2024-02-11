package tictactoe;

public class Board {
	
	public Cell[][] boxes;
	private final int noOfCell;
	
	
	public Board(int noOfCell) {
		this.noOfCell = noOfCell;
		boxes = new Cell[noOfCell][noOfCell];
		
	}
	
	public Cell[][] getBoxes() {
		return boxes;
	}
	
	public void setBoxes(Cell[][] boxes) {
		this.boxes = boxes;
	}
	
	public void printBoard() {
		
		for(int i = 0; i < noOfCell; i++) {
			System.out.print("|");
			for(int j = 0; j < noOfCell; j++) {
				System.out.print((boxes[i][j].getPiece() == null ? " " : boxes[i][j].getPiece()) + "|");
			}
			System.out.println();
		}
		
	}
	
	
	public void initializeBoard() {
		for(int i = 0; i < noOfCell; i++) {
			for(int j = 0; j < noOfCell; j++) {
				boxes[i][j] = new Cell(i, j, null);
			}
		}
		
		System.out.println("BOARD INITIALIZED");
	}
	
	

}