package lotto.view;

import java.util.List;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printPurchaseCount(final int count) {
        System.out.printf(PURCHASE_COUNT, count);
    }

    public static void printLottoNumbers(final List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
