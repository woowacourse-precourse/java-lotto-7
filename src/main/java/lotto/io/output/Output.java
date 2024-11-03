package lotto.io.output;

import static lotto.io.output.OutputMessage.ENTER_BONUS_NUMBER;
import static lotto.io.output.OutputMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.io.output.OutputMessage.MATCH_COUNT;
import static lotto.io.output.OutputMessage.MATCH_COUNT_WITH_BONUS;
import static lotto.io.output.OutputMessage.PURCHASED_COUNT;
import static lotto.io.output.OutputMessage.TOTAL_RETURN_RATE;
import static lotto.io.output.OutputMessage.WINNING_STATISTICS_HEADER;

import java.util.List;
import lotto.lotto.Lotto;
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

    public static void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void promptEnterWinningNumber() {
        System.out.println(OutputMessage.ENTER_WINNING_NUMBER.getMessage());
    }

    public static void promptEnterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public static void displayWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_HEADER.getMessage());
    }

    public static void displayMatchCount(LottoWinning winning, int count) {
//        System.out.printf(MATCH_COUNT.getMessage(), winning.getMatchedCount(), winning.getPrice(), winning.getCount());
        System.out.printf(MATCH_COUNT.getMessage(), winning.getMatchedCount(), winning.getPrice(), count);
    }

    public static void displayMatchCountWithBonus(LottoWinning winning, int count) {
        System.out.printf(MATCH_COUNT_WITH_BONUS.getMessage(), winning.getMatchedCount(), winning.getPrice(),
//                winning.getCount());
                count);
    }

    public static void displayTotalReturnRate(double returnRate) {
        System.out.printf(TOTAL_RETURN_RATE.getMessage(), returnRate);
    }
}
