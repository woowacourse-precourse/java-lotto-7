package lotto;

import controller.LottoController;
import purchase.PurchaseAmount;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isRunning = true;
        while (isRunning) {
            try {
                PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
                LottoController controller = new LottoController(purchaseAmount);
                controller.run();
                isRunning = false; // 정상 종료
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
                // 루프를 계속해서 재입력 요구
            }
        }
    }
}
