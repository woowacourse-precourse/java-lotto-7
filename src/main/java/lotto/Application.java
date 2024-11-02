package lotto;

import lotto.controller.LottoController;
import lotto.service.OutputService;

public class Application {
    public static void main(String[] args) {
        OutputService outputService = new OutputService();
        LottoController lottoController = new LottoController(outputService);
        lottoController.run();
    }
}
