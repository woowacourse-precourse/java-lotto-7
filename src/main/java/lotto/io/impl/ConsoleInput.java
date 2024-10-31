package lotto.io.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Input;
import lotto.io.Output;

public class ConsoleInput implements Input {

    private static ConsoleInput input;

    private final Output output;

    private ConsoleInput(Output output) {
        this.output = output;
    }

    public static ConsoleInput getInstance(Output output) {
        if(input == null)
            input = new ConsoleInput(output);

        return input;
    }

    public String inputMoney() {

        output.printPurchaseAmount();
        return Console.readLine();
    }
}
