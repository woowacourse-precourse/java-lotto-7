package lotto.view;

import lotto.constant.LottoGuide;
import lotto.model.Consumer;
import lotto.model.Lotto;


public class OutputView {
    public static void printPriceGuide() {
        System.out.println(LottoGuide.PRICE_GUIDE.getMessage());
    }

    public static void printLottoTicket(Consumer consumer) {
        printPurchaseCount(consumer.getLottoTicket().size());

        for (Lotto lotto : consumer.getLottoTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printPurchaseCount(int count) {
        System.out.printf(LottoGuide.PURCHASE_COUNT.getMessage(), count);
    }

    public static void printWinningNumberGuide() {
        System.out.println(LottoGuide.WINNING_NUMBER_GUIDE.getMessage());
    }

    public static void printBonusNumberGuide() {
        System.out.println(LottoGuide.BONUS_NUMBER_GUIDE.getMessage());
    }

    private static void printResultGuide() {
        System.out.println(LottoGuide.RESULT_GUIDE.getMessage());
        System.out.println(LottoGuide.LINE_SEPARATOR.getMessage());
    }

    public static void printResult(int[] matchingNumber, int bonusNumber) {
        printResultGuide();
        System.out.printf(LottoGuide.RESULT_FIFTH.getMessage(), matchingNumber[3]);
        System.out.printf(LottoGuide.RESULT_FOURTH.getMessage(), matchingNumber[4]);
        System.out.printf(LottoGuide.RESULT_THIRD.getMessage(), matchingNumber[5] - bonusNumber);
        System.out.printf(LottoGuide.RESULT_SECOND.getMessage(), bonusNumber);
        System.out.printf(LottoGuide.RESULT_FIRST.getMessage(), matchingNumber[6]);
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
