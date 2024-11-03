package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Number;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.console.Writer;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String WINNING_STATISTICS = "당첨통계" + NEW_LINE + "---";
    private static final String WINNING_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_SECOND_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String WINNING_RATE_SUM_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String LOTTO_OUTPUT_FORMAT = "[%s]";
    private static final String SEPARATOR = ", ";

    public void print(String message) {
        Writer.println(message);
    }

    public void printLottos(Lottos lottos) {
        Writer.println(
                String.format(PURCHASE_LOTTO_COUNT, lottos.getLottos().size())
        );
        for (Lotto lotto : lottos.getLottos()) {
            printLottoInfo(lotto);
        }
    }

    public void printResult(Result result) {
        Writer.println(WINNING_STATISTICS);

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> printResultInfo(rank, result));
    }

    public void printTotalProfitRate(double totalProfitRate) {
        Writer.println(getProfitRateFormat(totalProfitRate));
    }

    private String getProfitRateFormat(double totalProfitRate) {
        return String.format(WINNING_RATE_SUM_FORMAT, totalProfitRate);
    }

    private void printResultInfo(Rank rank, Result result) {
        Writer.println(
                String.format(
                        getWinningFormat(rank),
                        rank.getCorrectCount(),
                        rank.getPrize(),
                        result.getCount(rank)
                )
        );
    }

    private String getWinningFormat(Rank rank) {
        if (rank.getBonus()) {
            return WINNING_SECOND_FORMAT;
        }
        return WINNING_RESULT_FORMAT;
    }

    private void printLottoInfo(Lotto lotto) {
        Writer.println(
                String.format(
                        LOTTO_OUTPUT_FORMAT,
                        String.join(
                                SEPARATOR,
                                convert(lotto.getNumbers())
                        )
                )
        );
    }

    private List<String> convert(List<Number> numbers) {
        return numbers.stream()
                .map(number -> Integer.toString(
                        number.getValue()
                ))
                .toList();
    }
}
