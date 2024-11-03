package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {
    @Override
    public String price() {
        return Console.readLine();
    }

    @Override
    public String winningNumbers() {
        return Console.readLine();
    }

    @Override
    public String bonusNumber() {
        return Console.readLine();
    }
}
