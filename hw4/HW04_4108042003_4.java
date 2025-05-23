package hw4;
public class HW04_4108042003_4 extends doge_coin {

	public int doge(int[] price) {
		int maxProfit = 0;
		int pist = 0;
		int lsf = Integer.MAX_VALUE;
		for(int i = 0; i < price.length; i++) {
			if(price[i] < lsf){
                lsf = price[i];
            }
            pist = price[i] - lsf;
            if(maxProfit < pist){
            	maxProfit = pist;
            }
		}
		return maxProfit;
	}
}
