package lotto.view;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";

    public void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_FORMAT) + "%n", count);
    }
}
