package level3.다단계칫솔판매;

import java.util.HashMap;

public class Solution {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Seller> sellers = new HashMap<>();

        sellers.put("-", new Seller("-"));
        for (int i = 0; i < enroll.length; i++)
            sellers.put(enroll[i], new Seller(enroll[i]));

        for (int i = 0; i < referral.length; i++) {
            sellers.get(enroll[i]).referral = sellers.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            int sales = amount[i] * 100; //판매액
            Seller s = sellers.get(seller[i]);
            Seller.update(s, sales);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellers.get(enroll[i]).sum;
        }
        return answer;
    }

    static class Seller {
        Seller referral;
        String name;
        int sum;

        public Seller(String name) {
            this.name = name;
            this.referral = null;
            sum = 0;
        }

        public static void update(Seller seller, int remainedSales) {

            int referralProfit = remainedSales / 10;

            if (seller.referral.name.equals("-")) {
                seller.sum += (remainedSales - referralProfit);
            } else {
                seller.sum += (remainedSales - referralProfit);
                update(seller.referral, referralProfit);
            }
        }
    }
}
