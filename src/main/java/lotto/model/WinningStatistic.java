package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistic {
    public enum PrizeTier {
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }

    private final List<Integer> prizeCounts;
    private final double profitRate;

    public WinningStatistic(double profitRate) {
        this.profitRate = Math.round(profitRate * 100) / 100.0;
        this.prizeCounts = new ArrayList<>();
        for (int i = 0; i < PrizeTier.values().length; i++) {
            prizeCounts.add(0);
        }
    }

    public void addPrizeCount(PrizeTier tier) {
        prizeCounts.set(tier.ordinal(), prizeCounts.get(tier.ordinal()) + 1);
    }

    @Override
    public String toString() {
        return String.format(
                """
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        총 수익률은 %.1f%%입니다.""",
                prizeCounts.get(PrizeTier.FIFTH.ordinal()), prizeCounts.get(PrizeTier.FOURTH.ordinal()),
                prizeCounts.get(PrizeTier.THIRD.ordinal()), prizeCounts.get(PrizeTier.SECOND.ordinal()),
                prizeCounts.get(PrizeTier.FIRST.ordinal()), profitRate
        );
    }
}
