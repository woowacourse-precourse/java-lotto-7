package lotto.endpoint.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String input() {
        try {
            return Console.readLine();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
