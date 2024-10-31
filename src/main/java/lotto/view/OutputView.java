package lotto.view;

public class OutputView {
    public void printPurchasePriceRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", quantity);
    }
}
