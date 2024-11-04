package lotto.view.output;

import java.util.List;
import lotto.domain.Lotto;

public class LottoOutputView {
    public static void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
