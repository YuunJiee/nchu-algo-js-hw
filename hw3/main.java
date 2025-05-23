package hw3;
public class main {

	public static void main(String[] args) {
		String[] str = {"0011", "11111", "000111", "100011", "00001111"};
		HW03_4108042003_1 test = new HW03_4108042003_1();
		boolean[] ans = test.one0k(str);
		Stopwatch stopwatch = new Stopwatch();
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
		
		show(ans);
	}
	
	public static void show(boolean[] ans)
	{
		for(int i=0; i<ans.length; i++)
		{
			System.out.print(ans[i]+", ");
		}
		System.out.println();
	}

}
