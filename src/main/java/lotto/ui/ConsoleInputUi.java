package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputUi implements InputUi {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
