package hw9;

public class main {
	public static void main(String[] args) {
		//input
		int[][] A1 = {{0,1},{0,2},{1,3},{1,4},{2,5},{6,7}};
		HW09_4108042003_1 test = new HW09_4108042003_1();
		
		//call function
		int a = test.Distance(A1);
		System.out.println("LSD: "+a);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}
