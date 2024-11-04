package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Number;
import lotto.domain.rank.Rank;
import lotto.domain.rank.Result;
import lotto.global.contents.ViewMessage;
import lotto.view.console.Writer;

public class OutputView {

    public void print(String message) {
        Writer.println(message);
    }

    public void printLottos(Lottos lottos) {
        Writer.println(
                ViewMessage.PURCHASE_LOTTO_COUNT
                        .formatMessage(lottos.getLottos().size())
        );

        lottos.getLottos().forEach(this::printLottoInfo);
    }

    public void printResult(Result result) {
        Writer.println(ViewMessage.WINNING_STATISTICS);

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> printResultInfo(rank, result));
    }

    public void printTotalProfitRate(double totalProfitRate) {
        Writer.println(ViewMessage.WINNING_RATE_SUM_FORMAT
                .formatMessage(totalProfitRate)
        );
    }

    private void printResultInfo(Rank rank, Result result) {
        Writer.println(
                getWinningFormat(rank).formatMessage(
                        rank.getCorrectCount(),
                        rank.getPrize(),
                        result.getCount(rank)
                )
        );
    }

    private ViewMessage getWinningFormat(Rank rank) {
        if (rank.getBonus()) {
            return ViewMessage.WINNING_SECOND_FORMAT;
        }
        return ViewMessage.WINNING_RESULT_FORMAT;
    }

    private void printLottoInfo(Lotto lotto) {
        Writer.println(
                ViewMessage.LOTTO_OUTPUT_FORMAT
                        .formatMessage(ViewMessage.LOTTO_NUMBER_SEPARATOR
                                .joinMessage(convert(lotto.getNumbers()))
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
