package lotto;

import lotto.controller.LottoController;
import lotto.seirvce.LottoService;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;
import lotto.view.InputProvider.ConsoleInputProvider;

public class Application {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput(new ConsoleInputProvider());
        ConsoleOutput output = new ConsoleOutput();
        LottoService lottoService = new LottoService();
        LottoController controller = new LottoController(input, output, lottoService);

        try {
            controller.run();
        } finally {
            input.close();
        }
    }
}
