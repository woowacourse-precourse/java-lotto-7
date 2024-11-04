package lotto;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.controller.LottoController;
import lotto.service.LottoValidationService;

public class Application {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();
        LottoValidationService lottoValidationService = new LottoValidationService();
        LottoController lottoController = new LottoController(input, output, lottoValidationService);
        lottoController.run();
    }
}
