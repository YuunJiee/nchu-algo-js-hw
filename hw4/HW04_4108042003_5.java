package hw4;
public class HW04_4108042003_5 extends doge_coin {

	public int doge(int[] price) {
		int minPrice = price[0];
		int maxProfit = 0;
		for (int i = 0; i < price.length; i++) {
			if (price[i] < minPrice) {
			  minPrice = price[i];
			} else if (price[i] - minPrice > maxProfit) {
			  maxProfit = price[i] - minPrice;
			}
		}
		return maxProfit;
	}
}
