package lotto;

import lotto.Controller.LottoController;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        LottoController lottoController = new LottoController(consoleInputHandler, consoleOutputHandler,
                randomNumberGenerator);
        lottoController.startLotto();
    }
}
