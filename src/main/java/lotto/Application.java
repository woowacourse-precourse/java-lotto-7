package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultManager;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultManager lottoResultManager = new LottoResultManager();

        LottoController lottoController = new LottoController(lottoGenerator, lottoResultManager);
        lottoController.startLotto();

    }
}
