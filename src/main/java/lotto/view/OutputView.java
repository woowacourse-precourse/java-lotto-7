package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoQuantity(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.getIndex(0) + ", " + lotto.getIndex(1) + ", " + lotto.getIndex(2) + ", "
                    + lotto.getIndex(3) + ", " + lotto.getIndex(4) + ", " + lotto.getIndex(5) + "]");
        }
    }
}
