package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;
import lotto.view.InputProvider.ConsoleInputProvider;

public class Application {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput(new ConsoleInputProvider());
        ConsoleOutput output = new ConsoleOutput();
        LottoController controller = new LottoController(input, output);

        try {
            controller.run();
        } finally {
            input.close();
        }
    }
}
