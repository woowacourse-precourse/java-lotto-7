package lotto.io.output;

import static lotto.io.output.OutputMessage.ENTER_BONUS_NUMBER;
import static lotto.io.output.OutputMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.io.output.OutputMessage.MATCH_COUNT;
import static lotto.io.output.OutputMessage.MATCH_COUNT_WITH_BONUS;
import static lotto.io.output.OutputMessage.PURCHASED_COUNT;
import static lotto.io.output.OutputMessage.TOTAL_RETURN_RATE;
import static lotto.io.output.OutputMessage.WINNING_STATISTICS_HEADER;

import lotto.lotto.LottoWinning;

public class Output {

    private Output() {
    }

    public static void promptEnterPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public static void displayPurchasedCount(int count) {
        System.out.printf(PURCHASED_COUNT.getMessage(), count);
    }

    public static void promptEnterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public static void displayWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_HEADER.getMessage());
    }

    public static void displayMatchCount(LottoWinning winning) {
        System.out.printf(MATCH_COUNT.getMessage(), winning.getMatchedCount(), winning.getPrice(), winning.getCount());
    }

    public static void displayMatchCountWithBonus(LottoWinning winning) {
        System.out.printf(MATCH_COUNT_WITH_BONUS.getMessage(), winning.getMatchedCount(), winning.getPrice(),
                winning.getCount());
    }

    public static void displayTotalReturnRate(double returnRate) {
        System.out.printf(TOTAL_RETURN_RATE.getMessage(), returnRate);
    }
}
