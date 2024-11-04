package lotto.simulation;

import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.BuyAmount;

public class LottoSimulator {
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    public void run() {
        while (true) {
            consoleOutputHandler.buyAmountMessage();
            String buyAmountString = consoleInputHandler.buyAmount();
            try {
                BuyAmount buyAmount = new BuyAmount(buyAmountString);
            } catch (IllegalArgumentException e) {
                consoleOutputHandler.exceptionMessage(e);
            }
        }
    }
}
