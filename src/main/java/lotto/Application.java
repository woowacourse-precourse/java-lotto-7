package lotto;

import lotto.controller.LottoController;
import lotto.generator.LottoGenerator;
import lotto.service.LottoService;
import lotto.service.PrintService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGenerator lottoGenerator = new LottoGenerator();
        PrintService printService = new PrintService();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
        LottoController lottoController = new LottoController(lottoService, printService);
        lottoController.runLottoProgram();
    }
}
