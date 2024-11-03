package lotto.view;

import static lotto.view.OutputMessage.OUTPUT_EARNING_RATE;
import static lotto.view.OutputMessage.OUTPUT_EXCEPT_SECOND_PLACE_RESULT;
import static lotto.view.OutputMessage.OUTPUT_PURCHASE_QUANTITY;
import static lotto.view.OutputMessage.OUTPUT_SECOND_PLACE_RESULT;

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
        System.out.println(OUTPUT_PURCHASE_QUANTITY.format(lottoQuantity));
    }

    public static void displayWinningStatistics(double earningRate) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(DIVIDING_LINE);
        for (WinningInfo info : WinningInfo.values()) {
            if (info != WinningInfo.SECOND) {
                System.out.println(
                        OUTPUT_EXCEPT_SECOND_PLACE_RESULT.format(info.getMatchingNumberCount(), info.getPrizeMoney(),
                                info.getWinningTicketCount()));
                continue;
            }
            System.out.println(OUTPUT_SECOND_PLACE_RESULT.format(info.getMatchingNumberCount(), info.getPrizeMoney(),
                    info.getWinningTicketCount()));
        }
        System.out.println(OUTPUT_EARNING_RATE.format(earningRate));
    }
}
