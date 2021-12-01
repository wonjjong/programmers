package level2.숫자의표현;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 2;
        int sum = start;

        for(int i=end; i<= n*2;i++) {
            if(sum < n) {
                sum += end;
                end++;
            }
            else if( sum > n ) {
                sum -= start;
                start++;
            } else {
                answer++;
                sum += end;
                end++;
            }
        }

        return answer;
    }
}
