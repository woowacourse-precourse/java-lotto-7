package lotto.io;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class Output {
    private final String PRINT_LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private final String PRINT_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private final String PRINT_SEPARATING_LINE_MESSAGE = "---";
    private final String PRINT_EARNINGS_RATE_MESSAGE = "총 수익률은 ";
    private final String PRINT_PERCENT_MESSAGE = "% 입니다.";
    private final String PRINT_UNIT = "개";


    public void printLottoQuantity(int lottoQuantity) {
        printNewLine();
        System.out.println(lottoQuantity + PRINT_LOTTO_QUANTITY_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics() {
        printNewLine();
        System.out.println(PRINT_WINNING_STATISTICS_MESSAGE);
        System.out.println(PRINT_SEPARATING_LINE_MESSAGE);
    }

    public void printRanking(Map<Ranking, Integer> rankingResult) {
        for (Entry<Ranking, Integer> ranking : rankingResult.entrySet()) {
            System.out.println(ranking.getKey().getMessage() + ranking.getValue() + PRINT_UNIT);
        }
    }

    public void printEarningsRate(double earningsRate) {
        System.out.println(PRINT_EARNINGS_RATE_MESSAGE + earningsRate + PRINT_PERCENT_MESSAGE);
    }

    private void printNewLine() {
        System.out.println();
    }
}
