package lotto.controller;

import lotto.model.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void run() {
        Integer money = inputMoney();
    }

    private Integer inputMoney() {
        try {
            String rawMoney = inputView.inputMoney();
            inputValidator.validateInputMoney(rawMoney);

            return Integer.parseInt(rawMoney);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());

            return inputMoney();
        }
    }
}
