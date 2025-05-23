package hw1;
public class HW01_4108042003_2 extends ArrayData {
	int max;
	int min;
	
	public HW01_4108042003_2(int[] A) {
		this.A = A;
	}
	
	@Override
	public int max() {
		max = min = this.A[0];
		for(int i = 1; i < this.A.length; i++) {
			if(max < this.A[i]) {
				max = this.A[i];
			}else if(min > this.A[i]){
				min = this.A[i];
			}
		}
		return max;
	}
	
	@Override
	public int min() {
		return min;
	}
}
