package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {
    protected String readInput() {
        return Console.readLine();
    }
}
