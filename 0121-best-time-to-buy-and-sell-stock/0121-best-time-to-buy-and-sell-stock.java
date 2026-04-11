class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProf = 0;

        for(int i=0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                buyPrice = Math.min(prices[i], buyPrice);
                int profit = prices[i] - buyPrice;
                maxProf = Math.max(profit, maxProf);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProf;
    }
}