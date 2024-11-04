package lotto.view.input;

import static lotto.view.constants.InputMessages.INPUT_BONUS_NUMBER;
import static lotto.view.constants.InputMessages.INPUT_PURCHASE_AMOUNT;
import static lotto.view.constants.InputMessages.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {


    @Override
    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }


    @Override
    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
