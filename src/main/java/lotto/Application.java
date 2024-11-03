package lotto;

import lotto.controller.LottoMachine;
import lotto.service.LottoService;
import lotto.service.PurchaseService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine(
                new InputView(),
                new PurchaseService(),
                new LottoService()
        );

        lottoMachine.run();
    }
}
