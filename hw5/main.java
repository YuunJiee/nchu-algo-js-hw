package hw5;

public class main {

	public static void main(String[] args) {
		//input
		int[] A1 = {1,2,2};       //5
		int[] A2 = {0,1,3,3,5,2}; //14 
		int[] A3 = {2,5,1,6,4,8}; //9
		int[] A4 = {4,3,2,1,2,1}; //13
		int[] A5 = {1}; //1
		int[] A6= {1,3,4,3,0,1};
		
		HW05_4108042003_4 test = new HW05_4108042003_4();
		
		//call function
		int l_bit = test.l_bit(A6);
		System.out.println("little bit: " + l_bit);
		
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
}
