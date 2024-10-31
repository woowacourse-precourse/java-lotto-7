package lotto.controller;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();

        // 로또 구매

        // 당첨번호 입력

        // 보너스 번호 입력

        // 조회

        // 결과 출력
    }




    private int getPurchaseAmount() {
        while (true) {
            try {
                String rawPurchaseAmount = inputView.readRawPurchaseAmount();
                PurchaseAmountValidator.validate(rawPurchaseAmount);
                return Integer.parseInt(rawPurchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
