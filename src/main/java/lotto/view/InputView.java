package lotto.view;

import static lotto.enums.Message.INPUT_BONUS_NUMBER;
import static lotto.enums.Message.INPUT_PURCHASE_AMOUNT;
import static lotto.enums.Message.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
