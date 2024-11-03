package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {
    // TODO : 반환형 수정 필요할 수 있음
    public String determineRank(int matchCount, boolean isBonusContain) {
        String rank = "";

        if (matchCount < 3) {
            return "꽝";
        }
        if (matchCount == 3){
            return "5등";
        }
        if (matchCount == 4){
            return "4등";
        }
        if (matchCount == 5 && !isBonusContain){
            return "3등";
        }
        if (matchCount == 5 && isBonusContain){
            return "2등";
        }
        if (matchCount == 6){
            return "1등";
        }

        return rank;
    }

    // TODO : 심각!!!
    public Map<String,Integer> finalRank(List<String> ranking){
        Map<String,Integer> ranks = new HashMap<>();
        int noRank = 0;
        int rank5 = 0;
        int rank4 = 0;
        int rank3 = 0;
        int rank2 = 0;
        int rank1 = 0;

        for (String s : ranking) {
            if (s.equals("꽝")) {
                noRank++;
            }
            if (s.equals("5등")) {
                rank5++;
            }
            if (s.equals("4등")) {
                rank4++;
            }
            if (s.equals("3등")) {
                rank3++;
            }
            if (s.equals("2등")) {
                rank2++;
            }
            if (s.equals("1등")) {
                rank1++;
            }
        }

        ranks.put("꽝",noRank);
        ranks.put("5등",rank5);
        ranks.put("4등",rank4);
        ranks.put("3등",rank3);
        ranks.put("2등",rank2);
        ranks.put("1등",rank1);

        return ranks;
    }
}
