package lotto.application.ticket.view.output;

import static lotto.application.ticket.message.Message.EMPTY_STRING;
import static lotto.application.ticket.message.Message.LOTTO_FORMAT;
import static lotto.application.ticket.message.Message.NUMBER_DELIMITER;
import static lotto.application.ticket.message.Message.PURCHASE_MESSAGE;

import java.util.List;

public class LottoMessageFormatter {
    public String formatPurchaseMessage(int count) {
        return String.format(PURCHASE_MESSAGE, count);
    }

    public String formatLottoNumbers(List<Integer> numbers) {
        String numbersString = numbers.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + NUMBER_DELIMITER + b)
                .orElse(EMPTY_STRING);

        return String.format(LOTTO_FORMAT, numbersString);
    }
}
