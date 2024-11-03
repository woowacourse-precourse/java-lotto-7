package lotto.controller;

import lotto.dto.LottoPurchasedAmountInput;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outPutView;

    public LottoController(InputView inputView, OutputView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void start() {
        while (true) {
            try {
                LottoPurchasedAmountInput lottoPurchasedAmountInput = inputView.readLottoPurchasedAmount();
                return;
            } catch (LottoException e) {
                outPutView.printErrorMessage(e.getMessage());
            }
        }
    }
}
