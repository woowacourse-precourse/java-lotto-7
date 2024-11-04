package lotto.model;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

public class WinningStatistic {
    private final Map<PrizeTier, Integer> prizeCounts;
    private final double profitRate;

    public WinningStatistic() {
        this.profitRate = -1;
        this.prizeCounts = new EnumMap<>(PrizeTier.class);
        for (PrizeTier tier : PrizeTier.values()) {
            prizeCounts.put(tier, 0);
        }
    }

    private WinningStatistic(Map<PrizeTier, Integer> prizeCounts, double profitRate) {
        this.prizeCounts = prizeCounts;
        this.profitRate = Math.round(profitRate * 100) / 100.0;
    }

    public WinningStatistic createWithProfitRate(WinningStatistic statistic, double profitRate) {
        return new WinningStatistic(statistic.prizeCounts, profitRate);
    }

    public void addPrizeCount(PrizeTier tier) {
        prizeCounts.put(tier, prizeCounts.get(tier) + 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);

        for (PrizeTier tier : PrizeTier.values()) {
            String formattedPrize = numberFormat.format(tier.getPrizeAmount());
            if (tier == PrizeTier.SECOND) {
                result.append(String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        formattedPrize, prizeCounts.getOrDefault(tier, 0)));
                continue;
            }
            result.append(String.format("%d개 일치 (%s원) - %d개\n",
                    tier.getMatchCount(), formattedPrize, prizeCounts.getOrDefault(tier, 0)));
        }
        result.append(String.format("총 수익률은 %.1f%%입니다.", profitRate));
        return result.toString();
    }
}
