package lotto.io.input.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ConsoleMessages;
import lotto.io.input.GameInput;

public class InputConsole implements GameInput {

    @Override
    public String getPurchaseAmountInput() {
        System.out.println(ConsoleMessages.PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getWinningNumbersInput() {
        System.out.println(ConsoleMessages.WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getBonusNumberInput() {
        System.out.println(ConsoleMessages.BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }
}
