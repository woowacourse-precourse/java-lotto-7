package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {

    public void read() {
        String input = Console.readLine();
        validate(input);
    }

    public abstract void validate(String input);
}
