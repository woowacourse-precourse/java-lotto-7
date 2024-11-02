package lotto.view;

import lotto.messages.InputMessage;

public class BonusNumberInputView extends InputView{
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void validate(String input) {

    }
}
