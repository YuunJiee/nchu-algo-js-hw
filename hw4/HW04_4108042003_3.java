package hw4;
public class HW04_4108042003_3 extends doge_coin {

	public int doge(int[] price) {
		int maxProfit = 0;
		int lsf = Integer.MAX_VALUE;
		for(int i = 0; i < price.length; i++) {
			lsf = Math.min(lsf, price[i]);
			if(price[i] >= lsf) {
				maxProfit = Math.max(maxProfit, price[i] - lsf);
			}
		}
		return maxProfit;
	}
}
