package hw6;

public class HW06_4108042003_3 extends MedianOfArrays {

	public double find_median(int[][] arrays) {
		int totalElements = 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for (int[] array : arrays) {
            totalElements += array.length;
            minValue = Math.min(minValue, array[0]);
            maxValue = Math.max(maxValue, array[array.length - 1]);
        }
        
        
        
        
		return 0;
	}
	
}
