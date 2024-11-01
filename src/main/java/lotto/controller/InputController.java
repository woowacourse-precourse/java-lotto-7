package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;

    public InputController(InputView inputView, InputValidator inputValidator, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
    }

    public Money inputLottoPurchaseAmount() {
        while (true) {
            try {
                String inputLottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
                inputValidator.validatePurchaseAmount(inputLottoPurchaseAmount);
                return Money.from(inputLottoPurchaseAmount);
            } catch (RuntimeException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
