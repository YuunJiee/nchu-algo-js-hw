package hw5;
public class HW05_4108042003_3 extends littlebit{

	public int l_bit(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i=0; i<A.length; i++) {
        	left[i] = 1;
        	right[i] = 1;
		}
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            }else if(A[i] == A[i-1]) {
            	left[i] = left[i - 1];
            }
        }
        int sum = Math.max(left[A.length-1], right[A.length-1]);
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            }else if(A[i] == A[i+1]) {
            	right[i] = right[i + 1];
            }
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }
}
