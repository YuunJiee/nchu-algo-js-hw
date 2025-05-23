package hw5;
public class HW05_4108042003_2 extends littlebit{

	public int l_bit(int[] A) {
		int n = A.length;
        int sum = 0;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        for(int i=0; i<n; i++) {
        	left2right[i] = 1;
        	right2left[i] = 1;
		}
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }else if(A[i] == A[i-1]) {
            	left2right[i] = left2right[i - 1];
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }else if(A[i] == A[i+1]) {
            	right2left[i] = right2left[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

}
