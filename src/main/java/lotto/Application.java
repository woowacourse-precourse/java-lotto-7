package lotto;

import lotto.controller.LotteryMachine;
import lotto.model.LotteryIssuer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LotteryIssuer lotteryIssuer = new LotteryIssuer();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LotteryMachine lotteryMachine = new LotteryMachine(lotteryIssuer, inputView, outputView);
        lotteryMachine.run();
    }
}
