package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputPurchaseAmount() {
        return Integer.parseInt(readUserInput());
    }

    public static String inputWinningNumbers() {
        return readUserInput();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(readUserInput());
    }

    private static String readUserInput() {
       return readLine();
    }
}
