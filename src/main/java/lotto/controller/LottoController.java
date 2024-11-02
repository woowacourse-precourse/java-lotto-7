package lotto.controller;

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
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(inputView.InputLottoPurchaseAmount());
    }
}
