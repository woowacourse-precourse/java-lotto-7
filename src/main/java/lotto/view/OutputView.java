package lotto.view;

import static lotto.constant.LottoMessage.END_MESSAGE;
import static lotto.constant.LottoMessage.NEW_LINE;
import static lotto.constant.LottoMessage.PURCHASE_COUNT_MESSAGE;
import static lotto.constant.LottoMessage.TOTAL_RETURN_RATE_MESSAGE;

public class OutputView {
    public static void print(String output) {
        System.out.println(output);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(NEW_LINE.getMessage() + count + PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public static void printWinningStatistics(String statistics, String rate) {
        String outputStatistics = statistics + TOTAL_RETURN_RATE_MESSAGE.getMessage()
                + rate
                + END_MESSAGE.getMessage();

        print(outputStatistics);
    }
}
