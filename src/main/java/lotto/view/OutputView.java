package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String PROFIT_MESSAGE_PREFIX= "총 수익률은 ";
    private static final String PROFIT_MESSAGE_SUFFIX = "%입니다.";
    private static final String SEPARATOR_LINE = "---";
    private static final String COUNT_UNIT = "개";
    private static final String HYPHEN = " - ";
    private static final String NEW_LINE = "";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        System.out.println(NEW_LINE);
    }

    public static void printLottos(List<Lotto> lottos) {
        println(lottos.size() + LOTTO_PURCHASE_MESSAGE);
        lottos.forEach(OutputView::printLotto);
    }

    public static void printWinningStatistics(Map<LottoRanking, Integer> rankingCount, double profitRate) {
        println(WINNING_STATISTICS_MESSAGE);
        println(SEPARATOR_LINE);

        printWinningDetails(rankingCount);
        printProfitRate(profitRate);
    }

    private static void printLotto(Lotto lotto) {
        println(lotto.getNumbers().toString());
    }

    private static void printWinningDetails(Map<LottoRanking, Integer> rankingCount) {
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            println(lottoRanking.getMessage() + HYPHEN + rankingCount.getOrDefault(lottoRanking, 0) + COUNT_UNIT);
        }
    }

    private static void printProfitRate(double profitRate) {
        println(PROFIT_MESSAGE_PREFIX + profitRate + PROFIT_MESSAGE_SUFFIX);
    }
}
