package lotto.io;

import java.util.List;
import lotto.Lotto;

public class OutputPrinter {

    private static final String LOTTO_BUY_MESSAGE = "\n%d개를 구매했습니다.%n";

    public void printLottoCreated(List<Lotto> lottos) {
        System.out.printf(LOTTO_BUY_MESSAGE, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }
}
