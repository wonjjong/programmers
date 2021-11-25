package level2.스킬트리;

public class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String temp = "";
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (skill.indexOf(skill_trees[i].charAt(j)) != -1) {
                    temp += skill_trees[i].charAt(j);
                }
            }
            if (skill.startsWith(temp)) answer++;
        }
        return answer;
    }
}
