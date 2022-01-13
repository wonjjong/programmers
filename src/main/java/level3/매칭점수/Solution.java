package level3.매칭점수;

import java.util.*;

public class Solution {

    public static int solution(String word, String[] pages) {
        word = word.toLowerCase();

        Map<String, Page> map = new HashMap<>();
        for (int i = 0; i < pages.length; i++) {
            Page page = new Page(i, pages[i]);
            page.init(word);
            map.put(page.url, page);
        }

        for (String key : map.keySet()) {
            Page page = map.get(key);
            for (String externalLink : page.externalLinks) {
                if (map.containsKey(externalLink)) {
                    Page externalPage = map.get(externalLink);
                    externalPage.matchingScore += (page.defaultScore / (double) page.externalLinkScore);
                }
            }
        }

        ArrayList<Page> list = new ArrayList(map.values());
        list.sort((o1, o2) -> Double.compare(o2.matchingScore + o2.defaultScore, o1.matchingScore + o1.defaultScore));

        return list.get(0).index;
    }


    static class Page {
        int index;
        int defaultScore;
        int externalLinkScore;
        double matchingScore;
        ArrayList<String> externalLinks;
        String page;
        String url;

        public Page(int index, String page) {
            this.index = index;
            this.page = page;
            this.externalLinks = new ArrayList<>();
            this.matchingScore = 0;
        }

        public void init(String word) {
            setUrl();
            setDefaultScore(word);
            setExternaLinkScore();
        }

        public void setUrl() {
            int startIndex = page.indexOf("<meta property=\"og:url\"");
            int endIndex = page.indexOf("\"/>", startIndex);
            String urlTag = page.substring(startIndex, endIndex);
            int contentIndex = urlTag.indexOf("https://");
            this.url = urlTag.substring(contentIndex + 8);
        }

        public void setExternaLinkScore() {
            int bodyStartIndex = page.indexOf("<body>");
            int bodyEndIndex = page.indexOf("</body>", bodyStartIndex);
            String body = page.substring(bodyStartIndex + 6, bodyEndIndex);

            int index = body.indexOf("<a href=");
            while (index != -1) {
                int endIndex = body.indexOf(">", index + 1);
                String externalLink = body.substring(index + 17, endIndex - 1);
                this.externalLinks.add(externalLink);
                externalLinkScore++;
                index = body.indexOf("<a href=", index + 1);
            }
        }

        public void setDefaultScore(String word) {
            page = page.toLowerCase();
            int bodyStartIndex = page.indexOf("<body>");
            int bodyEndIndex = page.indexOf("</body>", bodyStartIndex);
            String body = page.substring(bodyStartIndex + 6, bodyEndIndex);

            int index = body.indexOf(word);
            while (index != -1) {
                if (index == 0) {
                    //맨 앞에 존재
                    if (!Character.isLowerCase(body.charAt(index + word.length()))) {
                        defaultScore++;
                    }
                } else if (index + word.length() == bodyEndIndex) {
                    //맨 마지막에 존재
                    if (!Character.isLowerCase(body.charAt(index - 1))) {
                        defaultScore++;
                    }
                } else {
                    //중간에 존재
                    if (!Character.isLowerCase(body.charAt(index + word.length())) && !Character.isLowerCase(body.charAt(index - 1)))
                        defaultScore++;
                }
                index = body.indexOf(word, index + 1);
            }
        }

    }
}
