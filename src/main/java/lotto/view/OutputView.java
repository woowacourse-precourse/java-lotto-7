package lotto.view;

public class OutputView {

    public void printPriceInputPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPurchasePrompt(int number) {
        System.out.println(number + "개를 구입했습니다.");
    }
}
