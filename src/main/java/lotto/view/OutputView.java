package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String OUTPUT_LOTTOS = "\n%d개를 구매했습니다.\n";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(OUTPUT_LOTTOS, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
