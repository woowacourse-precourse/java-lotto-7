package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoNumber(List<Lotto> lottos, int purchaseAmount) {
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }

        System.out.println();
    }
}
