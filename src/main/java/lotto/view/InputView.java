package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputLottoCost() {
        return readConsoleInput();
    }

    public static String inputWinningNumbers() {
        return readConsoleInput();
    }

    public static String inputBonusNumber() {
        return readConsoleInput();
    }

    private static String readConsoleInput() {
        return Console.readLine();
    }
}