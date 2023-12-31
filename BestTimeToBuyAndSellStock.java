public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int current = 0; current < prices.length - 1; current++) {
            int profit = 0;
            for (int future = current + 1; future < prices.length; future++) {
                if (prices[future] - prices[current] > profit)
                    profit = prices[future] - prices[current];
            }
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
