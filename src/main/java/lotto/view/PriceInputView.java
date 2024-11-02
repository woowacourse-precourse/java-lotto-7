package lotto.view;

import lotto.messages.InputMessage;

public class PriceInputView extends InputView{
    @Override
    protected void printInputMessage() {
        System.out.println(InputMessage.PRICE_INPUT_MESSAGE.getMessage());
    }

    @Override
    protected void validate(String input) {

    }
}
