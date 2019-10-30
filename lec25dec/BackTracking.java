package lec25dec;

public class BackTracking {
public static void main(String[] args) {
		// TODO Auto-generated method stub
// NQueens(new boolean[4][4],0,"");

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		boolean[][] visited = new boolean[4][4];
		blockedMaze(maze, 0, 0, "", visited);

	}

	/*
	 * public static void NQueens(boolean[][] board, int row, String asf) {
	 * 
	 * for (int col = 0; col < board[0].length; col++) { if (isItSafe(board, row,
	 * col)) { board[row][col] = true; NQueens(board, row + 1, col, asf + "{" + row
	 * + "-" + col + "}"); board[row][col] = false; } }
	 * 
	 * }
	 * 
	 * /* public static boolean isItSafe(boolean[][] board,int row,int col) {
	 * //vertical up int r=row-1; int c=col; while(r>=0) { if(board[r][c]==true) {
	 * return false; } r--;
	 * 
	 * } //diagonal right r=row-1; c=col+1; while(r>=0&&c<board[0].length){
	 * if(board[r][c]==true) { return false; } r--; c++; }
	 * 
	 * //diagonal left
	 * 
	 * r=row-1; c=col-1; while(r>=0&&c>=0) { if(board[r][c]==true) { return false; }
	 * r--; c--; } } }
	 */

	public static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1
				|| visited[row][col]) {
			return;
		}

		visited[row][col] = true;
		blockedMaze(maze, row + 1, col, ans + "B", visited);
		blockedMaze(maze, row - 1, col, ans + "T", visited);
		blockedMaze(maze, row, col - 1, ans + "L", visited);
		blockedMaze(maze, row, col + 1, ans + "R", visited);
		visited[row][col] = false;
	}
}