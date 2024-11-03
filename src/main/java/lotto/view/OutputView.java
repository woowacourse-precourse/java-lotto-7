package lotto.view;

import static lotto.constants.LottoConstants.*;

public class OutputView {

    public static void print(String string) {
        System.out.println(string);
    }

    public static void promptPurchaseAmount(boolean isFirstPrompt) {
        if (isFirstPrompt) {
            print(PURCHASE_AMOUNT_TEXT);
        }

        if (!isFirstPrompt) {
            print(LINE_SPACE + PURCHASE_AMOUNT_TEXT);
        }
    }

    public static void promptWinningNumbers() {
        print(LINE_SPACE + WINNING_NUMBERS_TEXT);
    }

    public static void promptBonusNumber() {
        print(LINE_SPACE + BONUS_NUMBER_TEXT);
    }

    public static void promptLottoCount(int lottoCount) {
        print(LINE_SPACE + lottoCount + LOTTO_COUNT_TEXT);
    }
}