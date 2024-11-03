package view;

import java.util.List;
import model.lotto.Lottos;
import model.result.EarningsRate;
import model.result.Rank;
import model.result.RankResult;

public class OutputView {

    private static final String PURCHASE_NOTICE = "%d개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계\n---";
    private static final String RANK_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String RANK_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String EARNINGS_RATE_NOTICE = "총 수익률은 %s입니다.";

    private final Writer writer;

    private OutputView(final Writer writer) {
        this.writer = writer;
    }

    public static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView(Writer.initiate());
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void displayLottos(final Lottos lottos, final int lottoCount) {
        String message = String.format(PURCHASE_NOTICE, lottoCount);

        writer.printLineBefore(message);
        writer.printSout(lottos.toString());
    }

    public void displayResult(RankResult result, EarningsRate earningsRate) {
        writer.printLineBefore(RESULT_HEADER);

        List<String> rankMessages = generateRankMessages(result);
        rankMessages.forEach(writer::printSout);

        writer.printSout(String.format(EARNINGS_RATE_NOTICE, earningsRate.toString()));
    }

    private List<String> generateRankMessages(RankResult result) {
        return Rank.sortedRanksExceptNone().stream()
                .map(rank -> {
                    int matchCount = result.getCountByRank(rank);
                    String formattedPrize = String.format("%,d", rank.getPrize());

                    if (rank == Rank.SECOND) {
                        return String.format(RANK_FORMAT_WITH_BONUS, rank.getMatchingCount(), formattedPrize, matchCount);
                    }
                    return String.format(RANK_FORMAT, rank.getMatchingCount(), formattedPrize, matchCount);
                })
                .toList();
    }
}
