package hw4;
public class HW04_4108042003_1 extends doge_coin {

	public int doge(int[] price) {
		int n = price.length;
		int maxProfit = 0;
		int minStockVal = Integer.MAX_VALUE;
		int i = 0;
		while(i < n) {
			minStockVal = Math.min(minStockVal, price[i]);
			if(price[i] >= minStockVal) {
				maxProfit = Math.max(maxProfit, price[i] - minStockVal);
			}
			i++;
		}
		return maxProfit;
	}

}
