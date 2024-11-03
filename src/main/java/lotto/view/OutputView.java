package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private final String PURCHASE_PROMPT = "개를 구매했습니다.";

    public void printLottos(List<Lotto> lottos) {
        br();
        System.out.println(lottos.size() + PURCHASE_PROMPT);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }

    void br() {
        System.out.println();
    }

}
