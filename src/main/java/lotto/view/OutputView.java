package lotto.view;

import lotto.model.Lottos;

public class OutputView {

    private static String COUNT_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.getSize() + COUNT_PURCHASE_LOTTO);
        System.out.println(lottos.getLottos());
    }
}
