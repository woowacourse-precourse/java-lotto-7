package lotto.service;

import lotto.view.InputView;

public class InputProcessor {

    private final InputView inputView;
    private final ValidateService validateService;

    public InputProcessor() {
        this.inputView = new InputView();
        this.validateService = new ValidateService();
    }

    public int parsePurchaseAmount() {
        while (true) {
            try {
                String userInput = inputView.inputPurchaseAmount();
                return validateService.validatePurchaseAmount(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
