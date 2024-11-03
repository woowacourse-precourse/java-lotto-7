package lotto.view;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printQuantity(int quantity) {
        System.out.printf("%d개를 구매했습니다.\n", quantity);
    }
}
