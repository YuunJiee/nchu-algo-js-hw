package hw6;

public class HW06_4108042003_1 extends MedianOfArrays {

	public double find_median(int[][] arrays) {
		int arrN = arrays.length;
		
		for(int i=0; i<arrN-1; i++) {
			int leftL = arrays[i].length;
			int rightL = arrays[i+1].length;
			int[] aux = new int[leftL+rightL];
			arrays[i+1] = merge(aux, arrays[i], arrays[i+1], leftL, rightL);
		}
		int[] NewArray = arrays[arrays.length-1];
		double median = 0;
		int n = NewArray.length;
		if(n%2==0) {
			median = (double)((NewArray[n/2-1]+NewArray[n/2])/2);
		}else {
			median = (double)(NewArray[n/2]);
		}
		
		return median;
	}
	
	public int[] merge(int a[], int[] l, int[] r, int left, int right) {
		int i=0, j=0, k=0;
		if(l[left-1] <= r[0]) {
			for(i=0; i<left; i++) {
				a[k++] = l[i];
			}
			for(i=0; i<right; i++) {
				a[k++] = r[i];
			}
		}else {
			while(i<left && j<right) {
				if(l[i] <= r[j]) {
					a[k++] = l[i++];
				}else {
					a[k++] = r[j++];
				}
			}
			while(i < left) {
				a[k++] = l[i++];
			}
			while(j < right) {
				a[k++] = r[j++];
			}
		}
		return a;
	}
	
	public void show(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
