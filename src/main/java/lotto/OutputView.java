package lotto;

import lotto.message.NotifyMessage;
import lotto.message.ResultMessage;

public class OutputView {
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
        System.out.printf(ResultMessage.THREE_MATCH_MESSAGE.getMessage(), threeMatches);
        System.out.printf(ResultMessage.FOUR_MATCH_MESSAGE.getMessage(), fourMatches);
        System.out.printf(ResultMessage.FIVE_MATCH_MESSAGE.getMessage(), fiveMatches);
        System.out.printf(ResultMessage.FIVE_WITH_BONUS_MATCH_MESSAGE.getMessage(), fiveMatchesWithBonus);
        System.out.printf(ResultMessage.SIX_MATCH_MESSAGE.getMessage(), sixMatches);
        System.out.println();
        System.out.printf(ResultMessage.PROFIT_RATE_MESSAGE.getMessage(), profitRate);
    }

    public static void printErrorMessage(String errorMassage) {
        System.out.println(DEFAULT_ERROR_MESSAGE + errorMassage);
    }
}
