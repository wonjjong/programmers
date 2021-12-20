package level2.타겟넘버;

public class Solution {
    public static int answer = 0;
    public static int[] nums;

    public static int solution(int[] numbers, int target) {
        nums = numbers;

        dfs(0, numbers.length,0, target);

        return answer;
    }

    public static void dfs(int index, int size, int sum, int target) {
        if (index == size) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(index + 1, size, sum + nums[index], target);
        dfs(index + 1, size, sum - nums[index], target);

    }

}
