package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static synchronized InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readUserInput() {
        return Console.readLine();
    }

}
