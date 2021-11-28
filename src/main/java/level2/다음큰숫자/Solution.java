package level2.다음큰숫자;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int bitN = Integer.bitCount(n);

        for(int i=n+1;i<=1000000;i++) {
            int bitCount = Integer.bitCount(i);
            if(bitCount == bitN) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
