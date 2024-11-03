package lotto.view.output.mock;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Statistics;
import lotto.view.output.OutputView;

public class MockOutputView implements OutputView {

    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계\n---";
    private static final String DEFAULT_MATCH_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String BONUS_MATCH_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private final List<String> output = new ArrayList<>();

    @Override
    public void printPurchaseResults(final List<Lotto> lottos) {
        output.add(String.format(PURCHASED_LOTTO_MESSAGE, lottos.size()));
        lottos.forEach(lotto -> output.add(lotto.getNumbers().toString()));
    }

    @Override
    public void printStatisticsResults(final Statistics statistics) {
        output.add(STATISTICS_HEADER);
        for (Rank rank : Rank.values()) {
            if (rank.isWinning()) {
                output.add(String.format(getRankPrintFormat(rank), rank.getMatchCount(), rank.getPrize(),
                        statistics.getWinningResult().getOrDefault(rank, 0)));
            }
        }
        output.add(String.format(YIELD_MESSAGE, statistics.getYield()));
    }

    private String getRankPrintFormat(final Rank rank) {
        if (rank.getBonusRequirement() == Rank.BonusRequirement.REQUIRED) {
            return BONUS_MATCH_FORMAT;
        }
        return DEFAULT_MATCH_FORMAT;
    }

    @Override
    public void printErrorMessage(final String message) {
        output.add(message);
    }

    public List<String> getOutput() {
        return new ArrayList<>(output);
    }
}
