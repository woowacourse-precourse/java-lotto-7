package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String getInput() {
        return Console.readLine();
    }

    @Override
    public void closeConsole() {
        Console.close();
    }
}
