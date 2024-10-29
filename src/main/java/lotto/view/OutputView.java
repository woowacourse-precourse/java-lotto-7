package lotto.view;

public class OutputView {

    private static final String ERROR = "[Error] ";
    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";

    public void printErrorMessage(final String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }

    public void printPurchaseAmount(final int amount) {
        System.out.println(amount + PURCHASE_QUANTITY);
    }
}
