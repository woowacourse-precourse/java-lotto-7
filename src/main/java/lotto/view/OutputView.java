package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASED_LOTTOS_MSG = "%d개를 구매했습니다.";

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASED_LOTTOS_MSG, lottos.size()));
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
