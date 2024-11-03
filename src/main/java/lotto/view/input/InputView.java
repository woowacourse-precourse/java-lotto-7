package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {
    public abstract String readInput();

    protected String prompt(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
