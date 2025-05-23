package hw2;
public class HW02_4108042003_2 extends FourSum {

	@Override
	public int F_sum(int[] A) {
		int count = 0;
		mergeSort(A);
		int limit = binarySearch(A, 0, 0, A.length-1);
		for(int i = 0; i<limit; i++) {
			for(int j = i+1; j<A.length-2; j++) {
				int left = j+1;
				int right = A.length-1;
				while(left<right) {
					int sum = A[i]+A[j]+A[left]+A[right];
					if(sum > 0) {
						right--;
					}else if(sum < 0) {
						left++;
					}else {
						count++;
						right--;
						left++;
					}
				}
			}
		}
		return count;
	}
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
	public int binarySearch(int[] A, int key, int l, int h) {
		if(key < A[l]) return -1;
		if(key > A[h]) return -1;
		if(key == A[l]) return -1;
		if(key == A[h]) return -1;
		int low = l, high = h;
		while(low+1 < high) {
			int mid = (low+high)/2;
			if(key < A[mid]) high = mid;
			else if(key > A[mid]) low = mid;
			else return mid;
		}
		return high;
	}
}