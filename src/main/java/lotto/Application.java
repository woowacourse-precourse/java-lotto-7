package lotto;


import lotto.controller.GameController;
import lotto.helper.handler.InputHandler;
import lotto.model.LottoMachine;
import lotto.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(lottoMachine, inputHandler, outputView);
        gameController.run();
    }


}
