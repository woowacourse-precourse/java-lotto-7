package lotto;

import lotto.model.Lotteries;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
<<<<<<< Updated upstream
        Lotteries lotteries = new Lotteries();
        Controller controller = new Controller(inputView, outputView, lotteries);
=======
        Controller controller = new Controller(inputView, outputView);
>>>>>>> Stashed changes
    }
}
