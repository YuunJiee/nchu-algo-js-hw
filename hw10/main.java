package hw10;

public class main {
	public static void main(String[] args) {
		//input
		int[][] A1 = {{1, 1}, {2, 4}, {2, 10}, {5, 4}, {4, 8}, {5, 5}, {8, 4}, {10, 2}, {10, 1}};
		int[][] A2 = {{3, 1}, {4, 5}, {5, 4}, {2, 11}, {9, 1}};
		int[][] A3 = {{100,10},{100,101},{100,100},{101,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
		HW10_4108042003_1 test = new HW10_4108042003_1();
		
		//call function
		int[][] a = test.bestPhone(A3);
		System.out.println("Best Phone: ");
		for (int[] an : a) {
            System.out.print(an[0] + "," + an[1] + "/");
        }
		System.out.print("\n");
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}
