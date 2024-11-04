package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

class ConsoleInputUi implements InputUi {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
