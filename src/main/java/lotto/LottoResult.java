package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> prizeCount = new HashMap<>();

    public LottoResult() {
        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void recordPrize(Prize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }

    public void displayResults(int totalCost) {
        int totalPrize = 0;
        System.out.println("당첨 통계\n---");

        Prize[] prizes = Prize.values();
        Arrays.sort(prizes, Comparator.comparingInt(Prize::ordinal).reversed());

        for (Prize prize : prizes) {
            int count = prizeCount.get(prize);
            int prizeMoney = prize.getPrizeMoney() * count;
            totalPrize += prizeMoney;

            if (prize != Prize.NONE) {  // "NONE" 등급은 출력하지 않습니다.
                String matchDescription = getMatchDescription(prize);
                System.out.printf("%s - %d개\n", matchDescription, count);
            }
        }

        double profitRate = ((double) totalPrize / totalCost) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private String getMatchDescription(Prize prize) {
        switch (prize) {
            case FIFTH: return "3개 일치 (5,000원)";
            case FOURTH: return "4개 일치 (50,000원)";
            case THIRD: return "5개 일치 (1,500,000원)";
            case SECOND: return "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case FIRST: return "6개 일치 (2,000,000,000원)";
            default: return "";
        }
    }
}
