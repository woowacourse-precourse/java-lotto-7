package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputHandler {

    public void printLottoStatus(Lottos lottos) {
        printNewLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
