package level2.주차요금계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> In = new HashMap<>();
        HashMap<String, Integer> parking = new HashMap<>();

        for (String record : records) {
            StringTokenizer stringTokenizer = new StringTokenizer(record);
            int time = dateToInt(stringTokenizer.nextToken());
            String carNum = stringTokenizer.nextToken();
            String cmd = stringTokenizer.nextToken();

            if ("IN".equals(cmd)) {
                In.put(carNum, time);
            } else {
                int parkingTime = time - In.get(carNum);
                parking.put(carNum, parking.getOrDefault(carNum, 0) + parkingTime);
                In.remove(carNum);
            }
        }

        for (String key : In.keySet()) {
            int time = dateToInt("23:59");
            int parkingTime = time - In.get(key);
            parking.put(key, parking.getOrDefault(key, 0) + parkingTime);
        }

        Object[] objects = parking.keySet().toArray();
        Arrays.sort(objects);
        int[] answer = new int[parking.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = cal(fees, parking.get(objects[i]));
        }
        return answer;
    }

    public static int cal(int[] fees, int parkingTime) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        if (parkingTime <= defaultTime) return defaultFee;
        else {
            return defaultFee + (int) Math.ceil((double) (parkingTime - defaultTime) / unitTime) * unitFee;
        }
    }

    public static int dateToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
