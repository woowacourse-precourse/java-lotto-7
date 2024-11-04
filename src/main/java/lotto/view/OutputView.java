package lotto.view;

import static lotto.constant.ErrorMessage.ERROR_TAG;
import static lotto.view.OutputMessage.OUTPUT_EARNING_RATE;
import static lotto.view.OutputMessage.OUTPUT_PURCHASE_QUANTITY;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningInfo;

public class OutputView {

    private static final String WINNING_STATISTICS_TITLE = "\n당첨 통계";
    private static final String DIVIDING_LINE = "---";

    public static void displayPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        displayPurchaseQuantity(purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            lotto.showNumbers();
        }
    }

    private static void displayPurchaseQuantity(int lottoQuantity) {
        printMessage(OUTPUT_PURCHASE_QUANTITY.format(lottoQuantity));
    }

    public static void displayWinningStatistics(double earningRate) {
        printMessage(WINNING_STATISTICS_TITLE);
        printMessage(DIVIDING_LINE);
        for (WinningInfo info : WinningInfo.values()) {
            printMessage(OutputMessage.formatWinningResult(info));
        }
        printMessage(OUTPUT_EARNING_RATE.format(earningRate));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        printMessage(ERROR_TAG + errorMessage);
    }
}
