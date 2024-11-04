package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();
        InputParser inputParser = new InputParser(inputView, validator);
        OutputView outputView = new OutputView();

        Lottos lottos = new Lottos();
        LottoFactory lottoFactory = new LottoFactory(lottos);
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(inputParser, outputView, lottoFactory, lottoService);

        lottoController.start();
    }
}
