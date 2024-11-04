package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.vo.Payment;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
