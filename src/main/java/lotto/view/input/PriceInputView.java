package lotto.view.input;

import lotto.enums.InputMessage;
import lotto.validator.input.PriceValidator;

public class PriceInputView extends InputView {
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.PRICE_INPUT_MESSAGE.getMessage());
    }

    @Override
    public void initializeValidator(){
        validator = new PriceValidator(inputValue);
    }

    @Override
    protected void validate() {
        validator.validate();
    }
}
