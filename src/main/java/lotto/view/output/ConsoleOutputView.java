package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Statistics;

public class ConsoleOutputView implements OutputView {

    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String STATISTICS_HEADER = "당첨 통계\n---";
    private static final String DEFAULT_MATCH_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String BONUS_MATCH_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    @Override
    public void printPurchaseResults(final List<Lotto> lottos) {
        System.out.printf(PURCHASED_LOTTO_MESSAGE, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    @Override
    public void printStatisticsResults(final Statistics statistics) {
        System.out.println(STATISTICS_HEADER);
        for (Rank rank : Rank.values()) {
            if (rank.isWinning()) {
                System.out.printf(getRankPrintFormat(rank), rank.getMatchCount(), rank.getPrize(),
                        statistics.getWinningResult().getOrDefault(rank, 0));
            }
        }
        System.out.printf(YIELD_MESSAGE, statistics.getYield());
    }

    private String getRankPrintFormat(final Rank rank) {
        if (rank.getBonusRequirement() == Rank.BonusRequirement.REQUIRED) {
            return BONUS_MATCH_FORMAT;
        }
        return DEFAULT_MATCH_FORMAT;
    }

    @Override
    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
