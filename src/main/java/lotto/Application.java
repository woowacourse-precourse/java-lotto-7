package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputParser inputParser = new InputParser(inputView);
        OutputView outputView = new OutputView();

        Lottos lottos = new Lottos();
        LottoFactory lottoFactory = new LottoFactory(lottos);
        LottoService lottoService = new LottoService(lottoFactory);
        LottoController lottoController = new LottoController(inputParser, outputView, lottoService);

        lottoController.start();
    }
}
