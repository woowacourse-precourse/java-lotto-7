package lotto.view;

import lotto.domain.WinningStatistics;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String MATCH_EXCEPT_SECOND_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String MATCH_SECOND_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printPurchaseCount(final int count) {
        System.out.printf(PURCHASE_COUNT, count);
    }

    public static void printLottoNumbers(final List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void printProfit(final float profit) {
        System.out.println(String.format(PROFIT_FORMAT, profit));
    }

    public static void printNotSecondPrize(WinningStatistics statistics) {
        System.out.println(String.format(MATCH_EXCEPT_SECOND_FORMAT, statistics.getMatchValue(),
                convert(statistics.getPrice()),
                statistics.getCount()));
    }

    public static void printSecondPrize(WinningStatistics statistics) {
        System.out.println(String.format(MATCH_SECOND_FORMAT, statistics.getMatchValue(),
                convert(statistics.getPrice()),
                statistics.getCount()));
    }


    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    private static String convert(int number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(number);
    }
}
