package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.ResultMessage;
public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(ResultMessage.LOTTO_COUNT.getMessage(), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
