package level1.실패율;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int[] solution(int N, int[] stages) {
        int peopleNum = stages.length;
        int[] challenge = new int[N + 1];

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) continue;
            challenge[stages[i]]++;
        }

        double[][] temp = new double[N][2];

        for (int i = 1; i <= N; i++) {
            temp[i - 1][0] = i;
            if (challenge[i] == 0)
                temp[i - 1][1] = 0;
            else
                temp[i - 1][1] = challenge[i] / (double) peopleNum;

            peopleNum -= challenge[i];
        }

        Arrays.sort(temp,
                new Comparator<double[]>() {
                    @Override
                    public int compare(double[] o1, double[] o2) {
                        if (o1[1] == o2[1]) {
                            return Double.compare(o1[0], o2[0]);
                        } else {
                            return Double.compare(o2[1], o1[1]);
                        }
                    }
                });

        int[] answer = new int[N];
        for (int i = 0; i < temp.length; i++) {
            answer[i] = (int) temp[i][0];
        }

        return answer;
    }
}
