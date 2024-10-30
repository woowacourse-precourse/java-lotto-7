package lotto.view;

public class OutputView {

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
