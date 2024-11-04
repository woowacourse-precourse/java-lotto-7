package lotto.view;

import static lotto.message.MessageConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.message.MessageConstants.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.message.MessageConstants.INPUT_WINNING_NUMBERS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine().trim();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine().trim();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine().trim();
    }

}
