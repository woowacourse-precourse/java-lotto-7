package lotto.view;

import static lotto.constant.LottoMessage.NEW_LINE;
import static lotto.constant.LottoMessage.PURCHASE_COUNT_MESSAGE;

public class OutputView {
    public static void print(String output) {
        System.out.println(output);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(NEW_LINE.getMessage() + count + PURCHASE_COUNT_MESSAGE.getMessage());
    }
}
