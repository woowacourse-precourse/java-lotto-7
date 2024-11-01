package lotto.custom.controller;

import lotto.custom.model.Lottos;
import lotto.custom.service.LottoPurchaseService;
import lotto.custom.view.InputView;
import lotto.custom.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoPurchaseService = new LottoPurchaseService();
    }

    public void run() {
        Lottos myLottoTickets = tryPurchaseLotto();
        outputView.displayLottoCount(myLottoTickets.size());
        outputView.displayLottos(myLottoTickets);
    }

    public Lottos tryPurchaseLotto() {
        Lottos lottos;
        while (true) {
            try {
                String purchaseAmountInput = inputView.inputPurchaseAmount();
                lottos = lottoPurchaseService.run(purchaseAmountInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
        return lottos;
    }
}