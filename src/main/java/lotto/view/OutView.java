package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}
