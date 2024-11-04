package lotto.model;

import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> prizeCounts;
    private final double roi;

    public LottoResult(Map<Prize, Integer> prizeCounts, double roi) {
        this.prizeCounts = prizeCounts;
        this.roi = roi;
    }

    public Map<Prize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public double getRoi() {
        return roi;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("당첨 통계\n---\n");
        for (Prize prize : Prize.values()) {
            builder.append(String.format("%d개 일치%s - %d개\n",
                    prize.getMatchCount(),
                    prize.getMessage(),
                    prizeCounts.getOrDefault(prize, 0)));
        }
        builder.append(String.format("총 수익률은 %.1f%%입니다.\n", roi));

        return builder.toString();
    }
}
