package lotto.view;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import lotto.view.message.RankMessage;
import lotto.view.message.SystemMessage;

public class OutputView {
    private static final int MAX_RANK = 5;
    private static final int MIN_RANK = 1;

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

    public static void printWinningStatistics() {
        System.out.println(SystemMessage.WINNING_STATISTICS.getMessage());
    }

    public static void printResults(HashMap<Integer, Integer> results) {
        for (int i = MAX_RANK; i >= MIN_RANK; i--) {
            System.out.printf(RankMessage.findByRank(i).getMessage(), results.get(i));
        }
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.printf(SystemMessage.RATE_OF_RETURN.getMessage(), rateOfReturn);
    }
}
