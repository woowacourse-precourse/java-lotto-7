package lotto.handler;

import static lotto.message.OutputMessage.PURCHASE_QUANTITY_OUTPUT_MESSAGE;

import java.util.List;
import lotto.Lotto;

public class OutputHandler {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[", SUFFIX = "]";

    public void printPurchaseResult(List<Lotto> lottoes) {
        System.out.println(
                String.format(PURCHASE_QUANTITY_OUTPUT_MESSAGE.getMessage(), lottoes.size())
        );

        lottoes.forEach(lotto -> {
            printLotto(lotto);
        });
    }

    private void printLotto(Lotto lotto) {
        List<String> result = lotto.getNumbers().stream()
                .map(String::valueOf).toList();
        System.out.println(PREFIX + String.join(DELIMITER, result) + SUFFIX);
    }
}
