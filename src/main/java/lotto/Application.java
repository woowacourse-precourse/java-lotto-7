package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.service.InputParser;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory(InputParser.parsePrice());
        LottoService lottoService = new LottoService(lottoFactory);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.start();
    }
}
