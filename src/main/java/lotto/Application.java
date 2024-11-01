package lotto;

import lotto.Controller.LottoController;
import lotto.Input.InputValidator;
import lotto.Input.InputView;
import lotto.Output.OutputView;
import lotto.Service.LottoService;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(lottoGenerator);

        LottoController lottoController = new LottoController(inputView,outputView,lottoService);
        lottoController.run();
    }
}
