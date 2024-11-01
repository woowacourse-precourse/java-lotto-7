package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    private static final String NEW_LINE = "%n";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    private static final String LOTTO_FORMAT = "[%s]%n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private OutputView() {
    }

    public static void println(String message) {
        System.out.print(message);
        System.out.printf(NEW_LINE);
    }

    public static void println() {
        println("");
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_FORMAT, lottos.count());
        for (Lotto lotto : lottos.toList()) {
            System.out.printf(
                    LOTTO_FORMAT,
                    String.join(LOTTO_NUMBER_DELIMITER, lotto.toSortedStrings())
            );
        }
    }
}
