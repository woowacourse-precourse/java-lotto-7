package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    public enum Prize {
        MATCH_3(5000),
        MATCH_4(50000),
        MATCH_5(1500000),
        MATCH_5_BONUS(30000000),
        MATCH_6(2000000000);

        private final int prizeAmount;

        Prize(int prizeAmount) {
            this.prizeAmount = prizeAmount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }

    private final Map<Prize, Integer> matchCounts = new EnumMap<>(Prize.class);

    public LottoStatistics() {
        for (Prize prize : Prize.values()) {
            matchCounts.put(prize, 0);
        }
    }

    public void incrementCount(int matchCount, boolean hasBonusMatch) {
        Prize key = switch (matchCount) {
            case 3 -> Prize.MATCH_3;
            case 4 -> Prize.MATCH_4;
            case 5 -> hasBonusMatch ? Prize.MATCH_5_BONUS : Prize.MATCH_5;
            case 6 -> Prize.MATCH_6;
            default -> null;
        };

        if (key != null) {
            matchCounts.put(key, matchCounts.get(key) + 1);
        }
    }

    public int getTotalPrize() {
        return matchCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public void printStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", matchCounts.get(Prize.MATCH_3));
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchCounts.get(Prize.MATCH_4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchCounts.get(Prize.MATCH_5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchCounts.get(Prize.MATCH_5_BONUS));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchCounts.get(Prize.MATCH_6));
    }
}
