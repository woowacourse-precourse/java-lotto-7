package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchasedLotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLottos(PurchasedLotto purchasedLotto) {
        List<Lotto> lottos = purchasedLotto.getLottos();
        promptPurchaseAmountResult(lottos.size());
        printLottoNumbers(lottos);
        printLine();
    }

    private static void promptPurchaseAmountResult(int amount) {
        System.out.println(amount + PURCHASED_AMOUNT_MESSAGE);
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printLine() {
        System.out.println();
    }

}
