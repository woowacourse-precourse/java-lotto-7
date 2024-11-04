package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.service.InputParser;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        Lottos lottos = new Lottos();
        LottoFactory lottoFactory = new LottoFactory(InputParser.parsePrice(), lottos);
        LottoService lottoService = new LottoService(lottoFactory);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.start();
    }
}
