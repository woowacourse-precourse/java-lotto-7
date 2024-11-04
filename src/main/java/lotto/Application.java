package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoInputHandler;
import lotto.service.LottoResultManager;
import lotto.service.LottoResultPrinter;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoInputHandler lottoInputHandler = new LottoInputHandler();
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();

        LottoController lottoController = new LottoController(lottoGenerator, lottoInputHandler, lottoResultPrinter);
        lottoController.startLotto();
    }
}
