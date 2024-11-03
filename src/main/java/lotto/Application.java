package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoStaticsOutputHandler;
import lotto.view.NumberOfLottoOutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        NumberOfLottoOutputHandler numberOfLottoOutputHandler = new NumberOfLottoOutputHandler(lottoService);
        LottoStaticsOutputHandler lottoStaticsOutputHandler = new LottoStaticsOutputHandler(lottoService);

        LottoController lottoController = new LottoController(lottoService, numberOfLottoOutputHandler, lottoStaticsOutputHandler);

        lottoController.run();
    }
}
