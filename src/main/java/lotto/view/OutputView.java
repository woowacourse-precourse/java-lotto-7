package lotto.view;

import static lotto.constant.InputMessage.*;

public class OutputView {

    public void printPriceInputMessage(){
        System.out.println(PRICE_INPUT_MESSAGE.getMessage());
    }

    public void printWinningNumberInputMessage(){
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printBonusNumberInputMessage(){
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }
}
