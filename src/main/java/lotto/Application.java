package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.generator.SortedLottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class Application {
    public static void main(String[] args) {
        int money = LottoInput.inputMoney();

        LottoController lottoController = new LottoController(new LottoService(new SortedLottoNumberGenerator()));
        List<Lotto> lottos = lottoController.purchase(money);
        LottoOutput.printPurchaseLotto(lottos);


    }
}
