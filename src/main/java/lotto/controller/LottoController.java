package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;
import model.ValidationManager;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final ValidationManager validationManager;

    public LottoController(InputView inputView, OutputView outputView, ValidationManager validationManager) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.validationManager = validationManager;
    }

    public void play(){
        String amountInput = handleAmountError();
    }

    public String handleAmountError(){
        boolean validInput = false;
        String amount="";
        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_AMOUNT_MESSAGE);
                amount= inputView.readInput();

                validationManager.isEmptyInput(amount, validationManager.NON_NUMERIC_ERROR);
                validationManager.isNumber(amount,validationManager.EMPTY_INPUT_ERROR);
                validInput=validationManager.isDivideByThousand(amount,validationManager.NOT_DIVISIBLE_BY_THOUSAND_ERROR);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;

    }
}
