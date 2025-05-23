package hw1;

public class HW01_4108042003_1 extends ArrayData {
	
	public HW01_4108042003_1(int[] A) {
		this.A = A;
	}
	
	@Override
	public int max() {
		int tMax = this.A[0];
		for(int i = 1; i < this.A.length; i++) {
			tMax = (tMax < this.A[i] ? this.A[i] : tMax);
		}
		return tMax;
	}
	
	@Override
	public int min() {
		int tmin = this.A[0];
		for(int i = 1; i < this.A.length; i++) {
			tmin = (tmin > this.A[i] ? this.A[i] : tmin);
		}
		return tmin;
	}
}
