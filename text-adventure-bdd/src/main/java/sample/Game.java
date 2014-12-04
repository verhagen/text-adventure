package sample;

public class Game {
	private Cell[][] matrix;
	private int width;
	private int height;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new Cell[width][height];
	}

	public void toggleCellAt(int column, int row) {
		if (matrix[column][row] == null) {
			matrix[column][row] = new Cell();
		}
		else {
			matrix[column][row] = null;
		}
	}

	public void visit(StringRenderer renderer) {
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (matrix[c][r] == null) {
					renderer.addCell(".");
				}
				else {
					renderer.addCell("X");
				}
			}
			renderer.nextRow();
		}
	}
}
