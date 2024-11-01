package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public static final String BUY_AMOUNT_MESSAGE_POSTFIX = "개를 구매했습니다.";

    public void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos.size() + BUY_AMOUNT_MESSAGE_POSTFIX);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
