package hw1;

public class HW01_4108042003_3 extends ArrayData {
	
	int min;
	int max;
	
	public HW01_4108042003_3(int[] A) {
		this.A = A;
	}

	public static void main(String[] args) {
		int[] A = {-100, 5, 2222, 45, 666, 90, 87, -55, 123, -88888};
		HW01_4108042003_3 test = new HW01_4108042003_3(A);
		System.out.println(test.max());
		System.out.println(test.min());
	}
	
	void getMinMax(int arr[], int n) {
		int i;
		
		if(n%2 == 0) {
			if(arr[0]> arr[1]) {
				max = arr[0];
				min = arr[1];
			}else {
				min = arr[0];
				max = arr[1];
			}
			i = 2;
		}else {
			min = arr[0];
			max = arr[0];
			i = 1;
		}
		
		while(i < n -1) {
			if(arr[i] > arr[i+1]) {
				if(arr[i] > max) {
					max = arr[i];
				}
				if(arr[i+1] < min) {
					min = arr[i+1];
				}
			}else {
				if(arr[i+1] > max) {
					max = arr[i+1];
				}
				if(arr[i] < min) {
					min = arr[i];
				}
			}
			i += 2;
		}
	}
	
	@Override
	public int max() {
		getMinMax(this.A, this.A.length);
		return max;
	}
	
	@Override
	public int min() {
		return min;
	}
}
