package lotto.io.printer;

import lotto.Lotto;

import java.util.StringJoiner;

public final class LottoPrinter {

    private static final String LOTTO_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_DELIMITER = ", ";


    private LottoPrinter() {
    }

    public static void printLottoQuantity(long quantity) {
        String result = String.format(LOTTO_QUANTITY_FORMAT, quantity);
        DefaultPrinter.printLine(result);
    }

    public static void printLotto(Lotto lotto) {
        StringJoiner resultBuilder = new StringJoiner(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX);
        for (int number : lotto.getNumbers()) {
            resultBuilder.add(String.valueOf(number));
        }
        DefaultPrinter.printLine(resultBuilder.toString());
    }

}
