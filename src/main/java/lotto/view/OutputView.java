package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    
    private OutputView() {
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
