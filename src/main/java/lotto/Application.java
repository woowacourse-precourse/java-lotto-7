package lotto;

import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        LottoSimulator lottoSimulator = new LottoSimulator(inputHandler, outputHandler);
        lottoSimulator.run();
    }

}
