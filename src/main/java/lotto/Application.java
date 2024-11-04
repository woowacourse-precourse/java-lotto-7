package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.provider.RandomNumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        RandomNumberProvider numberProvider = new RandomNumberProvider();
        DefaultRangeValidator rangeValidator = new DefaultRangeValidator();
        LottoMachine lottoMachine = new LottoMachine(numberProvider, rangeValidator);

        LottoController controller =
                new LottoController(consoleInput, consoleOutput, lottoMachine, rangeValidator);
        controller.start();
    }
}
