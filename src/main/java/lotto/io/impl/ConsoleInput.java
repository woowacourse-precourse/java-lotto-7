package lotto.io.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Input;
import lotto.io.Output;

public class ConsoleInput implements Input {

    private final Output output;

    public ConsoleInput(Output output) {
        this.output = output;
    }

    public String inputMoney() {

        output.printPurchaseAmount();
        return Console.readLine();
    }
}
