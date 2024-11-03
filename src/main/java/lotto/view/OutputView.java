package lotto.view;

public class OutputView {

    public void printPriceInputPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
