package hw8;

public class HW08_4108042003_1 extends MaxLandArea{
	
	public int maxLandArea(int[][] array) {
		int maxLand = 0;
		int rows = array.length;
		int cols = array[0].length;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(array[i][j] == 1) {
					int size = dfs(array, i, j);
					maxLand = Math.max(maxLand, size);
				}
			}
		}
		return maxLand;
	}
	
	private int dfs(int[][] array, int i, int j) {
		int rows = array.length;
		int cols = array[0].length;
		
		if(i<0 || i>=rows || j<0 || j>=cols || array[i][j] == 0) {
			return 0;
		}
		
		array[i][j] = 0;
		
		int size = 1;
		size += dfs(array, i-1, j);
		size += dfs(array, i+1, j);
		size += dfs(array, i, j-1);
		size += dfs(array, i, j+1);
		
		return size;
	}
}
