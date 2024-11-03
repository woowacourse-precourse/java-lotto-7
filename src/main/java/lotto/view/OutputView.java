package lotto.view;

import java.util.List;
import lotto.constants.OutputMessages;

public class OutputView {
    private OutputView() {

    }

    public static void printInsertMoney() {
        System.out.println(OutputMessages.INSERT_MONEY);
    }

    public static void printLottoCount(int count) {
        System.out.printf(OutputMessages.ANNOUNCE_LOTTO_COUNT_FORMAT, count);
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printInsertUserLotto() {
        System.out.println(OutputMessages.INSERT_LOTTO_NUMBERS);
    }

    public static void printInsertBonus() {
        System.out.println(OutputMessages.INSERT_BONUS_NUMBER);
    }

    public static void printWinningBanner() {
        System.out.println(OutputMessages.ANNOUNCE_WIN_RESULT);
    }

    public static void printDiviner() {
        System.out.println(OutputMessages.DIVINER);
    }

    public static void printWinningResult(int count, String prizeMoney, int hit, String bonus) {
        System.out.printf(OutputMessages.WIN_RESULT_FORMAT, count, bonus, prizeMoney, hit);
        System.out.println();
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printTotalProfit(String profit) {
        System.out.printf(OutputMessages.ANNOUNCE_PROFIT_FORMAT, profit);
    }
}
