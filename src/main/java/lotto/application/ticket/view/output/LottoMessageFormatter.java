package lotto.application.ticket.view.output;

import java.util.List;

public class LottoMessageFormatter {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_FORMAT = "[%s]";
    private static final String NUMBER_DELIMITER = ", ";

    public String formatPurchaseMessage(int count) {
        return String.format(PURCHASE_MESSAGE, count);
    }

    public String formatLottoNumbers(List<Integer> numbers) {
        String numbersString = numbers.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + NUMBER_DELIMITER + b)
                .orElse("");

        return String.format(LOTTO_FORMAT, numbersString);
    }
}
