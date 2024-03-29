package com.dsa.algo.sliding_window;

import com.dsa.Answer;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 1, 3, 1};
        Answer.print(prices, "Price Array");
        int profit = maxProfit(prices);
        Answer.print(profit, "Max profit from stock");
    }

    public static int maxProfit(int[] prices) {
        int min_value = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            if (price < min_value) {
                min_value = price;
            } else if (price - min_value > max_profit) {
                max_profit = price - min_value;
            }
        }
        return max_profit;
    }
}
