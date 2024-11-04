package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.model.strategy.RandomNumberGeneration;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());
        LottoService lottoService = new LottoService(lottoMachine);
        LottoController lottoController = new LottoController(lottoService, inputView, resultView);

        lottoController.run();
    }
}