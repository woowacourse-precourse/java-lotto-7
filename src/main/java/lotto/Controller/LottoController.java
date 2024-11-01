package lotto.Controller;

import lotto.Lotto;

import java.util.List;

public class LottoController {
    PurchaseController purchaseController;
    WinningController winningController;

    public LottoController() {
        purchaseController = new PurchaseController();
        winningController = new WinningController();
    }

    public void start() {
        List<Lotto> lottos = purchaseController.purchase();
        winningController.getWinning(lottos);
    }
}
