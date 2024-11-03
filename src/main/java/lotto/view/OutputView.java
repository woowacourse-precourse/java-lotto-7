package lotto.view;

import static lotto.constant.LottoOutputMessage.OUTPUT_PROFIT_RATE;
import static lotto.constant.LottoOutputMessage.OUTPUT_PURCHASE_COUNT;
import static lotto.constant.LottoOutputMessage.OUTPUT_WINNING_STATISTICS;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + OUTPUT_PURCHASE_COUNT);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics() {
        System.out.println();
        System.out.println(OUTPUT_WINNING_STATISTICS);

        // Todo 당첨 통계 출력
    }

    public void printProfitRate(String profitRate) {
        System.out.printf((OUTPUT_PROFIT_RATE) + "%n", profitRate);
    }
}
