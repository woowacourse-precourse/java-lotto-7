package lotto.view;

import static lotto.view.OutputMessage.SHOW_PURCHASE_COUNT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class OutputView {
    public static void printPurchasedResult(Money money, List<Lotto> lottos) {
        printPurchasedCount(money.getMoney());
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printPurchasedCount(int money) {
        printNewLine();
        System.out.printf(SHOW_PURCHASE_COUNT.getMessage(), money);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
