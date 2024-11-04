package lotto;

import controller.LottoController;
import services.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService service = new LottoService();
        LottoController lottoController = new LottoController(service);

        lottoController.run();
    }
}
