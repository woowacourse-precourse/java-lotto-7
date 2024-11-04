package lotto.util;

import lotto.view.InputView;

public class InputHandler {

    private final InputValidator inputValidator;
    private final InputView inputView;
    private final InputParser inputParser;

    public InputHandler(InputValidator inputValidator, InputParser inputParser, InputView inputView) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.inputView = inputView;
    }

    public int parseInputNumber(String inputPurchaseAmount) {
        return inputParser.parseInputNumber(inputPurchaseAmount);
    }

    public void validateInputPurchaseAmount(String inputPurchaseAmount) {
        inputValidator.validateInputPurchaseAmount(inputPurchaseAmount);
    }

    public String receivePurchaseAmount() {
        return inputView.receivePurchaseAmount();
    }

    public String receiveWinningNumbers() {
        return inputView.receiveWinningNumbers();
    }

    public String receiveBonusNumber() {
        return inputView.receiveBonusNumber();
    }

    public void validateBonusNumber(String bonusNumber) {
        inputValidator.validateBonusNumber(bonusNumber);
    }

    public void validateWinningNumbers(String winningNumbers) {
        inputValidator.validateWinningNumbers(winningNumbers);
    }
}
