package lotto;

import lotto.message.NotifyMessage;

public class OutputView {
    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String FIVE_WITH_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR] ";

    public static void notifyEnterMoneyToBuy() {
        System.out.println(NotifyMessage.ENTER_MONEY_MESSAGE.getMessage());
    }

    public static void notifyAmount(int amount) {
        System.out.printf(NotifyMessage.NOTIFY_AMOUNT_MESSAGE.getMessage(), amount);
    }

    public static void notifyEnterWinningMoney() {
        System.out.println(NotifyMessage.ENTER_WINNING_NUM_MESSAGE.getMessage());
    }

    public static void notifyEnterBonusMoney() {
        System.out.println(NotifyMessage.ENTER_BONUS_NUM_MESSAGE.getMessage());
    }

    public static void printStatistics(int threeMatches, int fourMatches, int fiveMatches, int fiveMatchesWithBonus,
                                       int sixMatches, double profitRate) {
        System.out.println(NotifyMessage.NOTIFY_RESULT_MESSAGE.getMessage());
        System.out.println(NotifyMessage.DIVIDER.getMessage());
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
