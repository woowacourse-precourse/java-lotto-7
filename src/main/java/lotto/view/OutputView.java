package lotto.view;

import static java.lang.String.format;

public class OutputView {
    private final static String INFORM_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS_TITLE = "당첨 통계";
    private final static String SEPARATOR = "---";

    public static void printPurchaseMessage(int lottoQuantity) {
        System.out.println(format(INFORM_PURCHASE_LOTTO_MESSAGE, lottoQuantity));
    }
}
