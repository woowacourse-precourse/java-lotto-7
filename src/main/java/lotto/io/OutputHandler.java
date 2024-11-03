package lotto.io;

public class OutputHandler {

    public void showPurchaseCostInputComments() {
        System.out.println("구입금액을 입력해주세요");
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

}
