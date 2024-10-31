package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class DrawGames {

    private InputView inputView;
    private OutputView outputView;
    private LottoController controller;
    private LottoControllerFactory controllerFactory;

    public DrawGames() {
        inputView = new InputView();
        outputView = new OutputView();
        controllerFactory = new LottoControllerFactory();
        controller = controllerFactory.createLottoController();
    }

    public void run() {
    }
}
