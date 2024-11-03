package lotto.view;

import java.util.Comparator;
import java.util.List;

public class OutputView {
    public static void printInputPurchaseAmountMessage() {
        System.out.println(SystemMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printLottoQuantity(int quantity) {
        System.out.printf(SystemMessage.LOTTO_QUANTITY.getMessage(), quantity);

    }

    public static void printLottoNumbers(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
        System.out.println(lotto);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(SystemMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(SystemMessage.INPUT_BONUS_NUMBER.getMessage());
    }
}
