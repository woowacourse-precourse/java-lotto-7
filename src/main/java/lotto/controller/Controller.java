package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;
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

        // 로또 구매
        LottoTicket lottoTicket = purchaseLottoTicket();

        // 로또 상태 출력

        // 당첨번호 입력

        // 보너스 번호 입력

        // 조회

        // 결과 출력
    }

    private LottoTicket purchaseLottoTicket() {
        while (true) {
            try {
                int purchaseAmount = getPurchaseAmount();
                return LottoStore.purchaseLottoTicket(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
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
