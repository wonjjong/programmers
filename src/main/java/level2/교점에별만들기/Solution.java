package level2.교점에별만들기;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    static long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
    static long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;

    public static String[] solution(int[][] line) {

        ArrayList<Coordinate> allCoordinate = getAllCoordinate(line);

        long row = maxY - minY + 1;
        long col = maxX - minX + 1;

        StringBuilder[] answer = new StringBuilder[(int) row];
        for (int i = 0; i < row; i++) {
            answer[i] = new StringBuilder();
            for (int j = 0; j < col; j++)
                answer[i].append(".");
        }

        for (Coordinate coordinate : allCoordinate) {
            int x = (int) (coordinate.x - minX);
            int y = (int) (maxY - coordinate.y);
            answer[y].setCharAt(x, '*');
        }

        String[] ans = new String[(int) row];
        for (int i = 0; i < row; i++) {
            ans[i] = new String(answer[i]);
        }

        return ans;
    }

    public static ArrayList<Coordinate> getAllCoordinate(int[][] line) {
        ArrayList<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                double a = line[i][0];
                double b = line[i][1];
                double e = line[i][2];

                double c = line[j][0];
                double d = line[j][1];
                double f = line[j][2];
                double denominator = (a * d) - (b * c);
                if (denominator == 0) continue;

                double x = ((b * f) - (e * d)) / denominator;
                double y = ((e * c) - (a * f)) / denominator;

                long ix = (long) x, iy = (long) y;
                if (x == ix && y == iy) {
                    maxX = Math.max(maxX, ix);
                    minX = Math.min(minX, ix);
                    maxY = Math.max(maxY, iy);
                    minY = Math.min(minY, iy);
                    list.add(new Coordinate(ix, iy));
                }
            }
        }
        return list;
    }

    static class Coordinate {
        long x;
        long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
