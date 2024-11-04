package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.WinningService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        WinningService winningService = new WinningService();
        LottoController lottoController = new LottoController(lottoService, winningService);

        lottoController.run();
    }
}
