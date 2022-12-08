package day08;

public class TaskD8 {

	private int[][] map;

	private int row = 0;
	private int size = 0;
	
	private int[] visibleTrees = { 0, 0, 0, 0 };
	private int highestScore = 0;
	
	public void readMap(String l) {
		String[] trees = l.trim().split("");

		if (map == null) {
			size = trees.length;
			map = new int[size][size];
		}

		for (int col = 0; col < size; col++) {
			map[row][col] = Integer.parseInt(trees[col]);
		}

		row++;
	}

	public int countVisibleTrees(int task) {
		int ans = 0;
		if (task == 1)
			ans = task1();
		else if (task == 2)
			ans = task2();

		return ans;
	}
	
	private int task1() {
		int count = 0;

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (row == 0 || col == 0 || row == size - 1 || col == size - 1) {
					count++;
				} else if (visibleFromTop(row, col) || visibleFromLeft(row, col) || visibleFromRight(row, col)
						|| visibleFromBottom(row, col))
					count++;
			}
		}

		return count;
	}

	private int task2() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				visibleFromTop(row, col);
				visibleFromLeft(row, col);
				visibleFromRight(row, col);
				visibleFromBottom(row, col);
				
				calcScenicScore();
			}
		}
		
		return highestScore;
	}
	
	private void calcScenicScore() {
		int score = 1;
		for (int i = 0; i < visibleTrees.length; i++) {
			score *= visibleTrees[i]; 
			visibleTrees[i] = 0;
		}
		
		if (score > highestScore)
			highestScore = score;
	}
	
	private boolean visibleFromTop(int x, int y) {
		int height = map[x][y];

		for (int row = x - 1; row >= 0; row--) {
			int nextHeight = map[row][y];
			visibleTrees[0]++;
			if (height <= nextHeight)
				return false;
		}

		return true;
	}

	private boolean visibleFromBottom(int x, int y) {
		int height = map[x][y];

		for (int row = x + 1; row < size; row++) {
			int nextHeight = map[row][y];
			visibleTrees[3]++;
			if (height <= nextHeight)
				return false;
		}

		return true;
	}

	private boolean visibleFromLeft(int x, int y) {
		int height = map[x][y];

		for (int col = y - 1; col >= 0; col--) {
			int nextHeight = map[x][col];
			visibleTrees[1]++;
			if (height <= nextHeight)
				return false;
		}

		return true;
	}

	private boolean visibleFromRight(int x, int y) {
		int height = map[x][y];

		for (int col = y + 1; col < size; col++) {
			int nextHeight = map[x][col];
			visibleTrees[2]++;
			if (height <= nextHeight)
				return false;
		}

		return true;
	}

}
