package lotto;

import controller.LottoController;
import exception.InvalidInputException;
import purchase.PurchaseAmount;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
            LottoController controller = new LottoController(purchaseAmount);
            controller.run();
        } catch (InvalidInputException e) {
            OutputView.printErrorMessage(e.getMessage());
        } catch (Exception e) {
            // 예상치 못한 예외를 처리하기 위한 일반적인 예외 처리
            OutputView.printErrorMessage("알 수 없는 오류가 발생했습니다.");
        }
    }
}
