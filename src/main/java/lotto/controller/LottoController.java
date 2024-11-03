package lotto.controller;

import lotto.dto.LottoPurchasedAmountInput;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Buyer;

public class LottoController {

    private final InputView inputView;
    private final OutputView outPutView;

    public LottoController(InputView inputView, OutputView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void start() {
        Buyer buyer = processLottoPurchase();
    }

    private Buyer processLottoPurchase() {
        while (true) {
            try {
                LottoPurchasedAmountInput lottoPurchasedAmountInput = inputView.readLottoPurchasedAmount();
                return Buyer.from(lottoPurchasedAmountInput.rawAmount());
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }
}
