package lotto;

import lotto.controller.LottoController;
import lotto.global.Validator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final InputView inputView = InputView.getInstance();
    private static final Validator validator = Validator.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final LottoService lottoService = new LottoService();


    public static void main(String[] args) {
        LottoController controller = new LottoController(inputView, validator, outputView,lottoService);
        controller.run();
    }
}
