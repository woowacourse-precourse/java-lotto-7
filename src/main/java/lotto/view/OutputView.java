package lotto.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.message.NotifyMessage;
import lotto.message.ResultMessage;

public class OutputView {
    public static void printBlankLine() {
        System.out.println();
    }

    public static void notifyEnterMoneyToBuy() {
        System.out.println(NotifyMessage.ENTER_MONEY_MESSAGE.getMessage());
    }

    public static void notifyAmount(int amount) {
        System.out.printf(NotifyMessage.NOTIFY_AMOUNT_MESSAGE.getMessage(), amount);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortedLottoNumbers.sort(Comparator.naturalOrder());
        System.out.println(sortedLottoNumbers);
    }

    public static void notifyEnterWinningNumbers() {
        System.out.println(NotifyMessage.ENTER_WINNING_NUM_MESSAGE.getMessage());
    }

    public static void notifyEnterBonusNumber() {
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
        System.out.printf(ResultMessage.PROFIT_RATE_MESSAGE.getMessage(), profitRate);
    }

    public static void printErrorMessage(String errorMassage) {
        System.out.println(errorMassage);
    }
}
