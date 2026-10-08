class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        int length = prices.length;
        int [] maxSellPriceForEachDay = new int [length];
        maxSellPriceForEachDay[length-1] = 0;

        for(int i = length-2 ; i >= 0 ; i--){
            maxSellPriceForEachDay[i] = Math.max(prices[i+1], maxSellPriceForEachDay[i+1]);
        }

        for(int i = 0 ; i < length ; i++){
            int currentMaxTrade = maxSellPriceForEachDay[i] - prices[i];
            maximumProfit = Math.max(maximumProfit, currentMaxTrade);
        }


        return maximumProfit;
    }
}
