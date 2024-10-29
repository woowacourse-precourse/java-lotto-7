package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";

    public void printPurchaseAmount(final int amount) {
        System.out.println(amount + PURCHASE_QUANTITY);
    }

    public void printPurchasedLottos(final List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append('\n');
        }
        System.out.println(sb);
    }
}
