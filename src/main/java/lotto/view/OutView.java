package lotto.view;

import lotto.model.Lottos;

public class OutView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
    }
}
