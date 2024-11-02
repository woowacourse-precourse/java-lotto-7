package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String STATISTICS_DELIMITER = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String WINNING_DETAIL_FORMAT = "%s (%,d원) - %d개%n";

    public void printPurchaseAmount(int count) {
        println();
        printf(PURCHASE_MESSAGE, count);
        println();
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(this::printLotto);
        println();
    }

    private void printLotto(Lotto lotto) {
        println(lotto.getNumbers().toString());
    }

    public void printWinningResult(LottoResult result) {
        printWinningStatisticsHeader();
        printWinningDetail(result);
        printProfitRate(result);
    }

    private void printWinningStatisticsHeader() {
        println();
        println(WINNING_STATISTICS);
        println(STATISTICS_DELIMITER);
    }

    private void printWinningDetail(LottoResult result) {
        result.getRankCounts().forEach(this::printRankResult);
    }

    private void printRankResult(LottoRank rank, Integer count) {
        if (rank != LottoRank.NONE) {
            printf(WINNING_DETAIL_FORMAT,
                    rank.getDescription(),
                    rank.getAmount(),
                    count);
        }
    }

    private void printProfitRate(LottoResult result) {
        printf(PROFIT_RATE_MESSAGE + NEW_LINE, result.calculateProfitRate());
    }

    public void printError(String message) {
        println(message);
    }

    private void println() {
        System.out.println();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}