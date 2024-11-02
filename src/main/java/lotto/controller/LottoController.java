package lotto.controller;

import static lotto.validator.LottoPurchaseAmountValidator.validateLottoPurchaseAmount;

import lotto.dto.LottoPurchaseAmount;
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
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(inputView.InputLottoPurchaseAmount());
        validateLottoPurchaseAmount(lottoPurchaseAmount.lottoPurchaseAmount());
    }
}
