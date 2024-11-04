package lotto;

import lotto.controller.LottoController;
import lotto.model.IssuedLotto;
import lotto.service.LottoService;
import lotto.service.OutputService;

public class Application {
    public static void main(String[] args) {
        IssuedLotto issuedLotto = new IssuedLotto();
        LottoService lottoService = new LottoService(issuedLotto);
        OutputService outputService = new OutputService();
        LottoController lottoController = new LottoController(outputService, lottoService);
        lottoController.run();
    }
}
