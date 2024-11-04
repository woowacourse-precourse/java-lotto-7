package controller;

import common.InputMessage;
import java.util.function.Consumer;
import validator.InputValidator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String purchaseAmount = getUserPayment();
    }

    private String getUserPayment() {
        outputView.showPrompt(InputMessage.USER_BUY_LOTTO.getMessage());
        return getInput(InputValidator::validataPurchaseAmount);
    }

    private String getInput(Consumer<String> validator) {
        while(true) {
            try {
                String input = inputView.getInput();
                validator.accept(input);

                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
