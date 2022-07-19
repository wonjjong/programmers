package level2.양궁대회;

class Solution {
    static int max = -1;
    static int[] answer = new int[11];

    public static int[] solution(int n, int[] info) {
        for (int i = 10; i >= 0; i--) {
            for (int j = info[i] + 1; j >= 0; j--) {
                int[] arr = new int[11];
                arr[i] = j;
                dfs(i, n, j, arr, info);
                arr[i] = 0;
            }
        }

        if (max == -1) {
            int[] tmp = new int[1];
            tmp[0] = -1;
            return tmp;
        }
        return answer;
    }

    public static void dfs(int idx, int n, int cnt, int[] arr, int[] info) {
        if (cnt == n) {
            int aSum = 0, bSum = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && arr[i] == 0) continue;

                if (info[i] >= arr[i]) {
                    aSum += 10 - i;
                } else if (arr[i] >= info[i]) {
                    bSum += 10 - i;
                }
            }
            if (bSum > aSum && max < (bSum - aSum)) {
                max = bSum - aSum;
                for (int i = 0; i < 11; i++) {
                    answer[i] = arr[i];
                }
            }
        }

        for (int i = idx - 1; i >= 0; i--) {
            for (int j = info[i] + 1; j >= 0; j--) {
                arr[i] = j;
                dfs(i, n, cnt + j, arr, info);
                arr[i] = 0;

            }
        }
    }
}