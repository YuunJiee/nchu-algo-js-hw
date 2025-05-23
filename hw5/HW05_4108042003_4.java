package hw5;

public class HW05_4108042003_4 extends littlebit{
	public int l_bit(int[] A) {
		int[] arr = new int[A.length];
		for(int i=0; i<A.length; i++) {
        	arr[i] = 1;
		}
	    for (int i = 1; i < A.length; i++) {
	        if (A[i] > A[i - 1]) {
	            arr[i] = arr[i - 1] + 1;
	        }else if(A[i] == A[i - 1]) {
	        	arr[i] = arr[i - 1];
	        }
	    }
	    int sum = arr[A.length - 1];
	    for (int i = A.length - 2; i >= 0; i--) {
	        if (A[i] > A[i + 1]) {
	            arr[i] = Math.max(arr[i], arr[i + 1] + 1);
	        }else if(A[i] == A[i + 1]) {
	        	arr[i] = Math.max(arr[i], arr[i + 1]);
	        }
	        sum += arr[i];
	    }
	    return sum;
	}
    
}

