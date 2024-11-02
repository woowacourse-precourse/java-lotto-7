package lotto.ui.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Prompt;

public class ConsolePrompt implements Prompt {

    @Override
    public String input() {
        return Console.readLine();
    }

}
