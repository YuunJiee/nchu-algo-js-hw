package hw2;
public class main {

	public static void main(String[] args) {
		int A[] = {1,0,-1,-2,7,3,6,-3,-5};
		HW02_4108042003_2 test = new HW02_4108042003_2();
		Stopwatch stopwatch = new Stopwatch();
		System.out.printf("FourSum: %d\n", test.F_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}

}
