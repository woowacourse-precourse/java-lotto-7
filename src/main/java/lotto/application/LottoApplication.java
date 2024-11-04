package lotto.application;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.service.Generator;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public void run(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView);
        Generator<Lotto> lottoGenerator = new LottoGenerator();
        LottoController lottoController = new LottoController(inputController,outputView,lottoGenerator);

        lottoController.run();
    }

}
