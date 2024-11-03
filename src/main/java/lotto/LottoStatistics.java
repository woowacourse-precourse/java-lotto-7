package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<String, Integer> matchCounts;

    public LottoStatistics() {
        matchCounts = new HashMap<>();
        matchCounts.put("3_MATCH", 0);
        matchCounts.put("4_MATCH", 0);
        matchCounts.put("5_MATCH", 0);
        matchCounts.put("5_MATCH_BONUS", 0);
        matchCounts.put("6_MATCH", 0);
    }

    public void incrementCount(int matchCount, boolean hasBonusMatch) {
        // 기본 키를 설정
        String key = matchCount + "_MATCH";

        // 보너스 번호 일치 여부에 따라 키 조정
        if (hasBonusMatch && matchCount == 5) {
            key = "5_MATCH_BONUS";
        }

        matchCounts.put(key, matchCounts.getOrDefault(key, 0) + 1);
    }

    public int getTotalPrize() {
        return (matchCounts.get("3_MATCH") * 5000) +
                (matchCounts.get("4_MATCH") * 50000) +
                (matchCounts.get("5_MATCH") * 1500000) +
                (matchCounts.get("5_MATCH_BONUS") * 30000000) +
                (matchCounts.get("6_MATCH") * 2000000000);
    }

    public void printStatistics() {
        System.out.println("3개 일치 (5,000원) - " + matchCounts.get("3_MATCH") + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts.get("4_MATCH") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts.get("5_MATCH") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts.get("5_MATCH_BONUS") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts.get("6_MATCH") + "개");
    }

}
