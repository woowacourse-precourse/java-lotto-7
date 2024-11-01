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
        handleUserInputError();
    }

    public void handleUserInputError(){
        boolean validInput = false;

        while (!validInput) {
            try {
                outputView.printRequest(OutputView.REQUEST_AMOUNT_MESSAGE);
                String amount= inputView.readInput();

                validInput=validationManager.isEmptyInput(amount, validationManager.NON_NUMERIC_ERROR);
                validInput=validationManager.isNumber(amount,validationManager.EMPTY_INPUT_ERROR);
                validInput=validationManager.isDivideByThousand(amount,validationManager.NOT_DIVISIBLE_BY_THOUSAND_ERROR);

            } catch (IllegalArgumentException e) {
                // 잘못된 입력에 대한 예외를 처리하고 다시 입력을 요청
                System.out.println(e.getMessage());
            }
        }
    }
}
