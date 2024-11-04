package lotto.view;

import lotto.model.lottery.PurchasedLotto;
import lotto.model.result.Result;
import lotto.model.result.ReturnRate;

public class View {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String RETURN_RATE_MESSAGE_FORMAT = "총 수익률은 %s입니다.";

    public void show(PurchasedLotto purchasedLotto) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, purchasedLotto.getCount());
        System.out.println(purchasedLotto.getFormatted());
    }

    public void show(Result result) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.print(result.getFormattedWinningDetails());
    }

    public void show(ReturnRate returnRate) {
        System.out.printf(RETURN_RATE_MESSAGE_FORMAT, returnRate.getFormatted());
    }
}
