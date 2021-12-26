package level3.네트워크;

public class Solution {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisitVertex = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isVisitVertex[i] == false) {
                answer++;
                visit(i, computers, isVisitVertex);
            }
        }
        return answer;
    }

    public static void visit(int v, int[][] computers, boolean[] isVisitVertex) {
        for (int i = 0; i < computers[v].length; i++) {
            if (computers[v][i] == 1 && !isVisitVertex[i]) {
                isVisitVertex[i] = true;
                visit(i, computers, isVisitVertex);
            }
        }
    }
}
