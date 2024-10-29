package lotto.view;

import static lotto.constant.InputMessage.PRICE_INPUT_MESSAGE;
import static lotto.constant.InputMessage.WINNING_NUMBER_INPUT_MESSAGE;

public class OutputView {

    public void printPriceInputMessage(){
        System.out.println(PRICE_INPUT_MESSAGE.getMessage());
    }

    public void printWinningNumberInputMessage(){
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
