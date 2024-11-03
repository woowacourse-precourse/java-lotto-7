package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ViewFacade;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ViewFacade viewFacade = new ViewFacade(inputView, outputView);
        LottoMachine lottoMachine = new LottoMachine();
        Parser parser = new Parser();
        LottoController lottoController = new LottoController(viewFacade, lottoMachine, parser);

        lottoController.run();
    }
}
