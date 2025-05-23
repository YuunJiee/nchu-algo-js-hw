package hw5;

public class HW05_4108042003_1 extends littlebit{

	public int l_bit(int[] A) {
		if(A.length == 1) {
			return 1;
		}
		int res = 1, pre = 1, count = 0;
		for(int i = 1; i < A.length; i++) {
			if(A[i] >= A[i-1]) {
				if(count > 0) {
					res += count*(count+1)/2;
					if(count >= pre) {
						res += count - pre + 1;
					}
					count = 0;
					pre = 1;
				}
				pre = (A[i] == A[i-1]) ? pre : pre + 1;
				res += pre;
			}else {
				count++;
			}
		}
		if(count > 0) {
			res += count*(count+1)/2;
			if(count >= pre) {
				res += count - pre + 1;
			}
		}
		return res;
	}
}
