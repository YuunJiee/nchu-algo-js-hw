package hw2;
public class HW02_4108042003_1 extends FourSum {
	
	private void mergeSort(int[] arr){
        int[] orderedArr = new int[arr.length];
        for(int i = 2; i < arr.length << 1; i = i << 1) {
            for(int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
	}
	
	public static void show(int[] A) {
		for(int b=0; b<A.length; b++) {
			System.out.printf("%d ", A[b]);
		}
		System.out.println();
	}

	@Override
	public int F_sum(int[] A) {
		int target = 0;
		int count = 0;
		mergeSort(A);
		for(int i = 0; i < A.length-3; i++) {
			if(i != 0 && A[i] == A[i-1])continue;
			
			for(int j = i+1; j < A.length-2; j++) {
				if(j != i+1 && A[j]==A[j-1]) {
					continue;
				}
				int left = j+1;
				int right = A.length-1;
				while(left<right) {
					int fourSum = A[i]+A[j]+A[left]+A[right];
					if(fourSum == target) {
						count++;
						left++;
						right--;
						while(left < right && A[left] == A[left-1]) {
							left++;
						}
						while(left < right && A[left] == A[right+1]) {
							right--;
						}
					}else if(fourSum < target) {
						left++;
					}else {
						right--;
					}
				}
			}
		}
			
		return count;
	}
}
