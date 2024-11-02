package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputPurchaseMoney() {
        OutputView.printInputMessage(OutputMessage.INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        OutputView.printInputMessage(OutputMessage.INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusWinningNumber() {
        OutputView.printInputMessage(OutputMessage.INPUT_BONUS_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
