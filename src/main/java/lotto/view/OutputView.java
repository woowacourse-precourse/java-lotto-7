package lotto.view;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private OutputView() {}

    public static void printBoughtLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(Lotto::printNumbers);
    }

//    public static void
}
