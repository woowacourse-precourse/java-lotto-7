package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printPurchasedLottoCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public void printPurchaserLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
        System.out.println();
    }
}
