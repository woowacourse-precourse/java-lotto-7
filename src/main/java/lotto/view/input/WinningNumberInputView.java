package lotto.view.input;

import lotto.enums.InputMessage;

public class WinningNumberInputView extends InputView {


    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
        System.out.println();
    }
}
