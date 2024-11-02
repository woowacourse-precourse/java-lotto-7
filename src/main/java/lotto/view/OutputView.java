package lotto.view;

import lotto.Lotto;
import lotto.constant.MessageConstants;

import java.util.List;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(MessageConstants.REQUEST_PURCHASE_AMOUNT);
    }

    public static void printLottoTickets(int purchaseCount, List<Lotto> lottos) {
        System.out.println(String.format(MessageConstants.PURCHASED_LOTTO_COUNT, purchaseCount));
        lottos.forEach(System.out::println);
    }

    public static void requestWinningNumbers() {
        System.out.println(MessageConstants.REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(MessageConstants.REQUEST_BONUS_NUMBER);
    }

    public static void printWinningStatistics(String benefitRate) {
        System.out.println(MessageConstants.WINNING_STATISTICS);
        System.out.println(MessageConstants.STATISTICS_DIVIDER);

        //결과 출력

        System.out.println(String.format(MessageConstants.TOTAL_RETURN_RATE, benefitRate));
    }
}
