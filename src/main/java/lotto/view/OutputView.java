package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.Parser;

public class OutputView {
    private static final String PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public void printIssuedLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + PURCHASE_OUTPUT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
