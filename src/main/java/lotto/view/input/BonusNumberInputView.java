package lotto.view.input;

import lotto.enums.InputMessage;

public class BonusNumberInputView extends InputView {
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
