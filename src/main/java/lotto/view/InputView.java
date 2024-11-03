package lotto.view;

import static lotto.constant.Message.BONUS_NUMBER_INPUT_GUIDE;
import static lotto.constant.Message.PURCHASE_AMOUNT_INPUT_GUIDE;
import static lotto.constant.Message.WINNER_NUMBER_INPUT_GUIDE;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputModel;

public class InputView {

    public void printPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
    }

    public void printWinnerNumberInput() {
        System.out.println(WINNER_NUMBER_INPUT_GUIDE);
    }

    public void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
    }

    public String getInput() {
        String input = Console.readLine();
        InputModel inputModel = new InputModel(input);
        return inputModel.getInput();
    }
}
