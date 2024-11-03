package lotto.view;

import lotto.messages.InputMessage;
import lotto.validator.WinningNumberValidator;

public class WinningNumberInputView extends InputView{


    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void initializeValidator() {
        validator = new WinningNumberValidator(inputValue);
    }

    @Override
    protected void validate() {
        validator.validate();
    }
}
