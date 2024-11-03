package lotto;

import lotto.Controller.LottoController;
import lotto.Model.LottoMachine;
import lotto.Service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        LottoService lottoService = new LottoService(lottoMachine);
        LottoController lottoController = new LottoController(lottoService);

        lottoController.run();
    }
}
