package level3.추석트래픽;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int solution(String[] lines) {
        int answer = 0;

        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] endTime = lines[i].split(" ")[1].split(":");
            int hour = Integer.parseInt(endTime[0]) * 3600;
            int minute = Integer.parseInt(endTime[1]) * 60;
            int second = Integer.parseInt(endTime[2].substring(0, endTime[2].indexOf(".")));
            int eT = (hour + minute + second) * 1000 + (Integer.parseInt(endTime[2].substring(endTime[2].indexOf(".") + 1)));

            String processTime = lines[i].split(" ")[2];
            int pT = (int) (Double.parseDouble(processTime.substring(0, processTime.length() - 1)) * 1000);

            int sT = eT - pT + 1;
            logs.add(new Log(sT, eT));
        }

        for (int i = 0; i < logs.size(); i++) {
            int startTime = logs.get(i).startTime;
            int endTime = logs.get(i).endTime;
            int startAnswer = 1;
            int endAnswer = 1;
            for (int j = 0; j < logs.size(); j++) {
                if (i == j) continue;
                if (canIncluded(startTime, logs.get(j))) {
                    startAnswer++;
                }
                if (canIncluded(endTime, logs.get(j))) {
                    endAnswer++;
                }
            }
            answer = Math.max(answer, Math.max(startAnswer, endAnswer));
        }

        return answer;
    }

    public static boolean canIncluded(int time, Log log) {
        return !(log.endTime < time || log.startTime > time + 999);

    }

    static class Log {
        int startTime;
        int endTime;

        public Log(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
