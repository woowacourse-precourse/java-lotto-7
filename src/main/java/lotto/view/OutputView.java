package lotto.view;

import static lotto.utils.Constants.*;

import java.util.List;

public class OutputView {
    public void printBuyResult(int count) {
        System.out.printf(OUTPUT_BUYING_COUNT_MESSAGE, count);
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottoTicket(List<Integer> numbers) {
        System.out.println(convertTicketToFormat(numbers));
    }

    private String convertTicketToFormat(List<Integer> numbers) {
        return "[" + convertNumbersToString(numbers) + "]";
    }

    private String convertNumbersToString(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        numbers.forEach(number -> result.append(number).append(", "));

        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
