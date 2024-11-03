package lotto.view.input;

import lotto.enums.InputMessage;
import lotto.validator.input.BonusNumberValidator;

public class BonusNumberInputView extends InputView {
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void initializeValidator() {
        validator = new BonusNumberValidator(inputValue);
    }

    @Override
    protected void validate() {
        validator.validate();
    }
}
