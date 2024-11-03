package lotto.view.input;

import lotto.enums.InputMessage;
import lotto.validator.input.WinningNumberValidator;

public class WinningNumberInputView extends InputView {


    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
