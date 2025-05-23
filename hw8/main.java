package hw8;

public class main {
	public static void main(String[] args) {
		//input
		int[][] A1 = {{0,1,1,0},
					  {1,0,1,1},
					  {0,1,1,1},
					  {0,0,1,0}};
		
		HW08_4108042003_2 test = new HW08_4108042003_2();
		
		//call function
		int a = test.maxLandArea(A1);
		System.out.println("MaxLandArea: "+a);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}
