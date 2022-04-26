package temp;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo","apeach","neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(id_list,report,k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {id_list.length};
        Map<String,Integer> id = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : id_list) {
            id.put(s,0);
        }

        for(String rep : report) {
            String[] split = rep.split(" ");
            String a = split[0];
            String b = split[1];
            if(map.containsKey(a)) {
                map.get(a).add(b);
            } else{
                List<String> strings = map.get(a);
                strings.add(b);
                map.put(a,strings);
            }
        }

        for (String s : map.keySet()) {
            List<String> strings = map.get(s);
            for (String string : strings) {
                id.put(s, id.get(string) + 1);
            }
        }
        for(int i=0;i<id_list.length;i++)
            System.out.println(id.get(id_list[i]));
        return answer;
    }
}