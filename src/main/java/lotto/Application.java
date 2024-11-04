package lotto;

import controller.LottoController;
import services.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        lottoController.run();
    }
}
