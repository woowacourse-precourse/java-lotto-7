package lotto;

import lotto.controller.InputHandler;
import lotto.controller.LotteryMachine;
import lotto.model.ProfitCalculator;

public class Application {
    public static void main(String[] args) {
        final InputHandler inputHandler = new InputHandler();
        final ProfitCalculator profitCalculator = new ProfitCalculator();
        final LotteryMachine machine = new LotteryMachine(inputHandler, profitCalculator);
        machine.run();
    }
}
