package lotto.domain.winning;

import static lotto.domain.winning.Rank.NOTHING;
import static lotto.domain.winning.Rank.SECOND;
import static lotto.resources.Constants.THOUSAND_UNIT;
import static lotto.resources.Messages.RESULT_MESSAGE;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.buyer.Buyer;
import lotto.domain.lotto.Lotto;

public class WinningStatistics {
    private final LottoMatcher lottoMatcher;
    private final LottoStatistics lottoStatistics;
    private final int totalSpent;

    private WinningStatistics(final LottoMatcher lottoMatcher, final LottoStatistics lottoStatistics,
                              final int totalSpent) {
        this.lottoMatcher = lottoMatcher;
        this.lottoStatistics = lottoStatistics;
        this.totalSpent = totalSpent;
    }

    public static WinningStatistics of(final LottoMatcher lottoMatcher, final Buyer buyer) {
        LottoStatistics statistics = LottoStatistics.createLottoStatistics();
        int totalSpent = buyer.getLottosCount() * THOUSAND_UNIT;

        return new WinningStatistics(lottoMatcher, statistics, totalSpent);
    }

    public void calculateWinningStatistics(final Buyer buyer, final WinningInfo winningInfo) {
        List<Lotto> buyerLottos = buyer.getbuyLottos().getLottos();

        for (Lotto lotto : buyerLottos) {
            Rank rank = lottoMatcher.calculateRank(lotto, winningInfo);
            lottoStatistics.addResult(rank);
        }
    }

    public double getReturnRate() {
        if (totalSpent == 0) {
            return 0.0;
        }
        return (double) lottoStatistics.getTotalPrize() / totalSpent * 100;
    }

    private List<Entry<Rank, Integer>> getSortedStatistics() {
        return getStatistics().entrySet().stream()
                .sorted(Comparator.comparingInt((Entry<Rank, Integer> e) -> e.getKey().getMatchCount())
                        .thenComparing(e -> e.getKey().getMatchBonusPriority()))
                .toList();
    }

    private String formatStatisticsEntry(Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue();

        if (rank == NOTHING) {
            return "";
        }

        return formatStatistics(rank, count);
    }

    private String formatStatistics(final Rank rank, final int count) {
        return getMatchCountString(rank)
                + getBonusMatchString(rank)
                + getPrizeString(rank)
                + getCountString(count);
    }

    private String getMatchCountString(final Rank rank) {
        return rank.getMatchCount() + "개 일치";
    }

    private String getBonusMatchString(final Rank rank) {
        if (rank == SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String getPrizeString(final Rank rank) {
        return " (" + String.format("%,d", rank.getPrize()) + "원) - ";
    }

    private String getCountString(final int count) {
        return String.format("%,d", count) + "개\n";
    }

    private String formatReturnRate() {
        return "총 수익률은 " + String.format("%.1f", getReturnRate()) + "%입니다.";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(RESULT_MESSAGE.getMessage()).append("\n");

        List<Entry<Rank, Integer>> sortedStatistics = getSortedStatistics();

        for (Entry<Rank, Integer> entry : sortedStatistics) {
            sb.append(formatStatisticsEntry(entry));
        }

        sb.append(formatReturnRate());
        return sb.toString();
    }

    public Map<Rank, Integer> getStatistics() {
        return lottoStatistics.getStatistics();
    }

}
