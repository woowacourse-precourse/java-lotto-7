package lotto.simulation;

import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.BuyAmount;

public class LottoSimulator {
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    public void run() {
        consoleOutputHandler.buyAmountMessage();
        String buyAmountString = consoleInputHandler.buyAmount();
        BuyAmount buyAmount = new BuyAmount(buyAmountString);
        int lottoAmount = buyAmount.lottoAmount();
        consoleOutputHandler.lottoAmountMessage(lottoAmount);
    }
}
