package lotto.util;

import lotto.domain.LottoRank;

import java.util.Map;

public class WinnigResult {
    private final Map<LottoRank, Long> rankCounts;
    private final double returnRate;

    public WinnigResult(Map<LottoRank, Long> rankCounts, double returnRate) {
        this.rankCounts = rankCounts;
        this.returnRate = returnRate;
    }

    public String generateWinnigStatistics() {
        StringBuilder sb = new StringBuilder("당첨 통계\n---\n");

        appendRankStatistics(sb, LottoRank.FIFTH, "3개 일치");
        appendRankStatistics(sb, LottoRank.FOURTH, "4개 일치");
        appendRankStatistics(sb, LottoRank.THIRD, "5개 일치");
        appendRankStatistics(sb, LottoRank.SECOND, "5개 일치, 보너스 볼 일치");
        appendRankStatistics(sb, LottoRank.FIRST, "6개 일치");

        sb.append(String.format("\n총 수익률은 %.1f%%입니다.", returnRate * 100));

        return sb.toString();
    }
    private void appendRankStatistics(StringBuilder sb, LottoRank rank, String matchDescription) {
        long count = rankCounts.getOrDefault(rank, 0L);
        sb.append(String.format("%s (%,d원) - %d개\n",
                matchDescription, rank.getPrize(), count));
    }
}
