package lotto;

import lotto.controller.LottoController;
import lotto.util.LottoMachine;
import lotto.util.ResultCalculator;
import lotto.view.UserInput;
import lotto.view.UserView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserView userView = new UserView();
        UserInput userInput = new UserInput();
        LottoMachine lottoMachine = new LottoMachine();
        ResultCalculator resultCalculator = new ResultCalculator();

        LottoController lottoController = new LottoController(userView, userInput ,lottoMachine, resultCalculator);

        try {
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
