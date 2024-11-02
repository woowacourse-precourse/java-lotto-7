package lotto;

import lotto.controller.LottoController;
import lotto.model.SoldLotto;
import lotto.service.LottoService;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        LottoValidation lottoValidation = new LottoValidation();

        SoldLotto soldLotto = new SoldLotto();

        LottoService lottoService = new LottoService(soldLotto);

        LottoController lottoController = new LottoController(outputView, inputView, lottoValidation, lottoService);
        lottoController.run();
    }
}
