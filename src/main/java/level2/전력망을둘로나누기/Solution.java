package level2.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            vertex.add(new ArrayList<>());

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;
            vertex.get(v1).add(v2);
            vertex.get(v2).add(v1);
        }

        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;

            vertex.get(v1).remove((Integer) v2);
            vertex.get(v2).remove((Integer) v1);

            int diff = getDiff(v1, v2, n);

            vertex.get(v1).add(v2);
            vertex.get(v2).add(v1);

            answer = Math.min(diff, answer);
        }

        return answer;
    }

    private static int getDiff(int v1, int v2, int n) {
        boolean[] isVisitA = new boolean[n];
        boolean[] isVisitB = new boolean[n];

        isVisitA[v1] = true;
        int v1Sum = getSum(v1, isVisitA);

        isVisitB[v2] = true;
        int v2Sum = getSum(v2, isVisitB);

        return Math.abs(v1Sum - v2Sum);
    }

    private static int getSum(int v1, boolean[] isVisit) {
        int sum = 1;
        for (int i = 0; i < vertex.get(v1).size(); i++) {
            int v = vertex.get(v1).get(i);
            if (isVisit[v]) continue;
            else {
                isVisit[v] = true;
                sum += getSum(v, isVisit);
            }
        }
        return sum;
    }

}
