package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.OutputService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        OutputService outputService = new OutputService();
        LottoController lottoController = new LottoController(outputService, lottoService);
        lottoController.run();
    }
}
