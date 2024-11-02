package lotto.view;

import lotto.messages.InputMessage;

public class WinningNumberInputView extends InputView{
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void validate(String input) {

    }
}
