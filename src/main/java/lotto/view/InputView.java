package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.PrintMessage;

public class InputView {
    public String enterPurchaseAmount() {
        System.out.println(PrintMessage.INPUT_PURCHASE_AMOUNT_PROMPT.getMessage());
        return Console.readLine();
    }

    public String enterWinningNumbers() {
        System.out.println(PrintMessage.INPUT_WINNING_NUMBERS_PROMPT.getMessage());
        return Console.readLine();
    }

    public String enterBonusNumber() {
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER_PROMPT.getMessage());
        return Console.readLine();
    }
}
