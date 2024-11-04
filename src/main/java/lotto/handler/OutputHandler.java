package lotto.handler;

import static lotto.message.OutputMessage.PRIZE_RATIO_OUTPUT_MESSAGE;
import static lotto.message.OutputMessage.PURCHASE_QUANTITY_OUTPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_COUNT_OUTPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_STATICS_OUTPUT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatics;

public class OutputHandler {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[", SUFFIX = "]";

    public void printPurchaseResult(List<Lotto> lottoes) {
        System.out.println();
        System.out.println(
                String.format(PURCHASE_QUANTITY_OUTPUT_MESSAGE.getMessage(), lottoes.size())
        );

        lottoes.forEach(this::printLotto);
    }

    public void printWinningStatics(WinningStatics winningStatics) {
        System.out.println();
        System.out.println(WINNING_STATICS_OUTPUT_MESSAGE.getMessage());

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            int count = winningStatics.getWinningCount(rank);
            System.out.println(
                    String.format(WINNING_COUNT_OUTPUT_MESSAGE.getMessage(), rank.getMessage(), count)
            );
        }
    }

    public void printPrizeRatio(double prizeRatio) {
        System.out.println(String.format(PRIZE_RATIO_OUTPUT_MESSAGE.getMessage(), prizeRatio));
    }

    private void printLotto(Lotto lotto) {
        List<String> result = lotto.getNumbers().stream()
                .map(String::valueOf).toList();
        System.out.println(PREFIX + String.join(DELIMITER, result) + SUFFIX);
    }
}
