package hw4;
public class HW04_4108042003_2 extends doge_coin {

	public int doge(int[] price) {
		int maxProfit = 0;
		int lsf = 0;
		for(int i = price.length-1; i >= 0; i--) {
			lsf = Math.max(lsf, price[i]);
			if(price[i] <= lsf) {
				maxProfit = Math.max(maxProfit, lsf - price[i]);
			}
		}
		return maxProfit;
	}
}
