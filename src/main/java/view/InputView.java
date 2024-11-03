package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputInitialMoney() {
        OutputView.printInputMessage(OutputMessages.INPUT_INITIAL_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        OutputView.printInputMessage(OutputMessages.INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusWinningNumber() {
        OutputView.printInputMessage(OutputMessages.INPUT_BONUS__NUMBER_MESSAGE);
        return Console.readLine();
    }
}
