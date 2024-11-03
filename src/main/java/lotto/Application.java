package lotto;

import lotto.controller.LottoController;
import lotto.domain.AutomaticLottoMachine;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new AutomaticLottoMachine());
        lottoController.run();
    }
}
