package lotto.controller;

import java.util.InputMismatchException;
import lotto.utils.Utils;
import lotto.validator.Validators;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validators validators;
    private final Utils utils;


    public Controller(InputView inputView, OutputView outputView, Validators validators, Utils utils) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validators = validators;
        this.utils = utils;
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                String inputPrice = inputView.lottoPrice();
                validators.validateNumericInput(inputPrice);
                int price = utils.parseStringToInt(inputPrice);
                validators.validatePurchaseAmountUnit(price);
                return price;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
