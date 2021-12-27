package level3.베스트앨범;

import java.util.*;

public class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, ArrayList<Music>> genre = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            if (genre.containsKey(genreName)) {
                //map에 존재
                ArrayList<Music> arrayList = genre.get(genreName);
                arrayList.add(new Music(i, plays[i]));
                genre.put(genreName, arrayList);

                sum.put(genreName, sum.get(genreName) + plays[i]);
            } else {
                //map에 존재 X
                ArrayList<Music> arrayList = new ArrayList<>();
                arrayList.add(new Music(i, plays[i]));
                genre.put(genreName, arrayList);
                sum.put(genreName, plays[i]);
            }
        }

        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(sum.entrySet());
        entryList.sort((o1,o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
            String key = stringIntegerEntry.getKey();
            ArrayList<Music> music = genre.get(key);
            Collections.sort(music);
            for(int i=0;i<music.size() && i < 2;i++)
                answer.add(music.get(i).uniqueNumber);
        }

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    static class Music implements Comparable<Music> {
        int uniqueNumber;
        int playCount;

        public Music(int uniqueNumber, int playCount) {
            this.uniqueNumber = uniqueNumber;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Music o) {
            if (this.playCount == o.playCount) {
                return Integer.compare(this.uniqueNumber, o.uniqueNumber);
            } else
                return Integer.compare(o.playCount, this.playCount);
        }
    }
}
