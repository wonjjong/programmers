package level2.주식가격;

import java.util.Stack;

public class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Stock> s = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!s.isEmpty() && s.peek().price > prices[i]) {
                answer[s.peek().time] = i - s.peek().time;
                s.pop();
            }
            s.push(new Stock(prices[i], i));
        }

        while (!s.isEmpty()) {
            Stock stock = s.pop();
            answer[stock.time] = prices.length - stock.time - 1;
        }

        return answer;
    }

    static class Stock {
        int price;
        int time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }
}
