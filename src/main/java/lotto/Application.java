package lotto;

import lotto.Service.LottoService;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ViewFacade;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ViewFacade viewFacade = new ViewFacade(inputView, outputView);
        LottoService service = new LottoService();

        LottoController lottoController = new LottoController(viewFacade, service);
        lottoController.run();
    }
}
