package lotto;

import global.io.InputHandler;
import global.io.OutputHandler;
import global.io.console.ConsoleInputHandler;
import global.io.console.ConsoleOutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        LottoGame lottoGame = new LottoGame(inputHandler, outputHandler);
        lottoGame.run();
    }
}
