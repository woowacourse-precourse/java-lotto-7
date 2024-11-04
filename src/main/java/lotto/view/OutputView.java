package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public void printPurchasedLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
