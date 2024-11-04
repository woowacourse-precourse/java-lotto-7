package lotto.handler;

import static lotto.message.OutputMessage.PURCHASE_QUANTITY_OUTPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_COUNT_OUTPUT_MESSAGE;
import static lotto.message.OutputMessage.WINNING_STATICS_OUTPUT_MESSAGE;

import java.text.NumberFormat;
import java.util.List;
import lotto.Lotto;
import lotto.Rank;
import lotto.WinningStatics;

public class OutputHandler {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[", SUFFIX = "]";

    public void printPurchaseResult(List<Lotto> lottoes) {
        System.out.println(
                String.format(PURCHASE_QUANTITY_OUTPUT_MESSAGE.getMessage(), lottoes.size())
        );

        lottoes.forEach(lotto -> printLotto(lotto));
    }

    public void printWinningStatics(WinningStatics winningStatics) {
        System.out.println(WINNING_STATICS_OUTPUT_MESSAGE.getMessage());

        for (Rank rank : Rank.values()) {
            int count = winningStatics.getWinningCount(rank);
            String prize = NumberFormat.getInstance().format(rank.getPrize());
            System.out.println(
                    String.format(WINNING_COUNT_OUTPUT_MESSAGE.getMessage(), rank.getMatchCount(), prize, count)
            );
        }
    }

    private void printLotto(Lotto lotto) {
        List<String> result = lotto.getNumbers().stream()
                .map(String::valueOf).toList();
        System.out.println(PREFIX + String.join(DELIMITER, result) + SUFFIX);
    }
}
