package lotto.ui.prompt.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.prompt.Prompt;

public class ConsolePrompt implements Prompt {

    @Override
    public String input() {
        return Console.readLine();
    }

}
