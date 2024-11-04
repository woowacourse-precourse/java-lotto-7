package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        String purchaseAmountInput = InputView.inputPurchase();
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmountInput);
        OutputView.printPurchasedLottos(lottos);
    }
}
