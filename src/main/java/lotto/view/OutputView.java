package lotto.view;

import static lotto.constants.LottoConstants.*;

public class OutputView {

    public static void print(String string) {
        System.out.println(string);
    }

    public static void promptPurchaseAmount() {
        print(PURCHASE_AMOUNT_TEXT);
    }

    public static void promptWinningNumbers() {
        print(WINNING_NUMBERS_TEXT);
    }

    public static void promptBonusNumber() {
        print(BONUS_NUMBER_TEXT);
    }
}