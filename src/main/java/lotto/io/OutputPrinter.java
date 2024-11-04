package lotto.io;

import static lotto.LottoConstant.PRIZE_MAX_COUNT;
import static lotto.LottoConstant.PRIZE_MIN_COUNT;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Rank;
import lotto.Result;

public class OutputPrinter {

    private static final String DETAIL_FORMAT = "%s (%s원) - %d개\n";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String LOTTO_BUY_MESSAGE = "\n%d개를 구매했습니다.%n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";

    public void printLottoCreated(List<Lotto> lottos) {
        System.out.printf(LOTTO_BUY_MESSAGE, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public void printResult(Result result) {
        printResultMessage();
        printDetail(result.getWinningDetails());
        printRateOfReturn(result.getRateOfReturn());
    }

    private void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private void printDetail(Map<Rank, Integer> details) {
        StringBuilder outputBuilder = new StringBuilder();
        for (int i = PRIZE_MIN_COUNT; i <= PRIZE_MAX_COUNT; i++) {
            Rank rank = Rank.values()[i];
            int count = details.get(rank);
            String message = String.format(DETAIL_FORMAT, rank.getContent(), rank.getConvertedPrize(), count);
            outputBuilder.append(message);
        }

        System.out.print(outputBuilder);
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}
