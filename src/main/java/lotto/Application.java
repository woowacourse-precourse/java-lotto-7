package lotto;

import controller.LottoController;
import purchase.PurchaseAmount;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
            LottoController controller = new LottoController(purchaseAmount);
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            main(args); // 재귀 호출로 재입력 요구
        }
    }
}
