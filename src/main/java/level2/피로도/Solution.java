package level2.피로도;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static int answer =0;
    boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {

        int dungeonsLength = dungeons.length;
        isVisited = new boolean[dungeonsLength];

        dfs(k, dungeonsLength,dungeons,0);
        return answer;
    }

    public void dfs(int remainedFatigue, int dungeonsLength, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for(int i=0; i<dungeonsLength;i++) {

            if(remainedFatigue >= dungeons[i][0]) {
                if(isVisited[i]) continue;
                isVisited[i] = true;
                dfs(remainedFatigue - dungeons[i][1], dungeonsLength, dungeons, count+1);
                isVisited[i] = false;
            }
        }

    }
}
