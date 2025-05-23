package hw7;

public class main {
	public static void main(String[] args) {
		//input
		int[][] A1 = {{1,2},{1,3},{2,4},{1,4}};
		int[][] A2 = {{0,0},{1,0},{1,1},{0,1}};
		int[][] A3 = {{1,1},{2,2},{3,3},{4,4}};
		
		HW07_4108042003_2 test = new HW07_4108042003_2();
		
		//call function
		boolean a = test.checkLLK(A2);
		System.out.println("There are three points in a line: " + a);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}