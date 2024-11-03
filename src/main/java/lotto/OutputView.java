package lotto;

public class OutputView {
    private static final String ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NOTIFY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NOTIFY_RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String FIVE_WITH_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";

    public static void notifyEnterMoneyToBuy() {
        System.out.println(ENTER_MONEY_MESSAGE);
    }

    public static void notifyAmount(int amount) {
        System.out.println(amount + NOTIFY_AMOUNT_MESSAGE);
    }

    public static void notifyEnterWinningMoney() {
        System.out.println(ENTER_WINNING_NUM_MESSAGE);
    }

    public static void notifyEnterBonusMoney() {
        System.out.println(ENTER_BONUS_NUM_MESSAGE);
    }

    public static void printStatistics(int threeMatches, int fourMatches, int fiveMatches, int fiveMatchesWithBonus,
                                       int sixMatches, double profitRate) {
        System.out.println(NOTIFY_RESULT_MESSAGE);
        System.out.println(DIVIDER);
        System.out.printf((THREE_MATCH_MESSAGE) + "%n", threeMatches);
        System.out.printf((FOUR_MATCH_MESSAGE) + "%n", fourMatches);
        System.out.printf((FIVE_MATCH_MESSAGE) + "%n", fiveMatches);
        System.out.printf((FIVE_WITH_BONUS_MATCH_MESSAGE) + "%n", fiveMatchesWithBonus);
        System.out.printf((SIX_MATCH_MESSAGE) + "%n", sixMatches);
        System.out.println();
        System.out.printf((PROFIT_RATE_MESSAGE) + "%n", profitRate);
    }

    public static void printErrorMessage(String errorMassage) {
        System.out.println(DEFAULT_ERROR_MESSAGE + errorMassage);
    }
}
