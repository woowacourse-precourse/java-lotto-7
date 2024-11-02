package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;

public class MainController {

    public void run() {
        int amount = runPurchaseAmount();
        List<Lotto> lottos = runSetLottos(amount);
    }

    public int runPurchaseAmount() {
        AmountController amountController = new AmountController();
        int amount = amountController.inputAmount();
        return amount;
    }

    public List<Lotto> runSetLottos(int amount) {
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = lottoController.lottoController(amount);
        return lottos;
    }

}
