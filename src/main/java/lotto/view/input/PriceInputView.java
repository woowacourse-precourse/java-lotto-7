package lotto.view.input;

import lotto.enums.InputMessage;

public class PriceInputView extends InputView {
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.PRICE_INPUT_MESSAGE.getMessage());
    }
}
