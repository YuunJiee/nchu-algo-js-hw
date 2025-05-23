package hw6;

public class main {

	public static void main(String[] args) {
		//input
		int[][] A1 = {{1, 3,10},{-1, 5, 7},{-2, 5, 12}};
		int[][] A2 = {{3},{-1,5},{-2,5,12},{1,1,1},{4}};
		
		HW06_4108042003_2 test = new HW06_4108042003_2();
		
		//call function
		double median = test.find_median(A2);
		System.out.println("median: " + median);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}
