package hw4;

public class main {

	public static void main(String[] args) {
		//input
		int[] price = {7,1,5,3,10};
		
		HW04_4108042003_5 test = new HW04_4108042003_5();
		
		//call function
		int maxProfit = test.doge(price);
		System.out.println("max Profit: " + maxProfit);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}

}
