package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoController controller = new LottoController(lottoService);
        controller.run();
    }
}
