package lotto.controller;

import static lotto.validator.LottoPurchaseAmountValidator.validateLottoPurchaseAmount;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void setUp() {
        outputView.printLottoPurchaseAmountMessage();
        String lottoPurchaseAmount = inputView.InputLottoPurchaseAmount();
        validateLottoPurchaseAmount(lottoPurchaseAmount);
    }
}
