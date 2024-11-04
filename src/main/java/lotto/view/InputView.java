package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String getUserInput() {
        String input = Console.readLine();
        return input;
    }
}
