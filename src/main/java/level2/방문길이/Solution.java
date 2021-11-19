package level2.방문길이;

public class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] isVisited = new boolean[11][11][11][11];
        int currentX = 5, currentY = 5;


        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int newX = currentX, newY = currentY;
            switch (dir) {
                case 'U':
                    newY = currentY + 1;
                    break;
                case 'L':
                    newX = currentX - 1;
                    break;
                case 'R':
                    newX = currentX + 1;
                    break;
                case 'D':
                    newY = currentY - 1;
                    break;
            }
            if (isInMap(newX, newY)) {
                //좌표평면의 경계를 넘어가지 않는 경우
                if (!isVisited[currentX][currentY][newX][newY]) {
                    //가는 길은 단방향이지만 계산할 때는 양방향으로 계산해야함
                    isVisited[currentX][currentY][newX][newY] = true;
                    isVisited[newX][newY][currentX][currentY] = true;
                    answer++;
                }
                currentX = newX;
                currentY = newY;

            }

        }

        return answer;
    }

    boolean isInMap(int x, int y) {
        return x >= 0 && x <= 10 && y >= 0 && y <= 10;
    }
}

