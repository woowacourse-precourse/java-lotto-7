package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        Lotto[] purchasedLotto = lottoController.purchaseLotto();
        Lotto winningLotto = lottoController.setWinningNumber();
        lottoController.checkLottoStats(purchasedLotto, winningLotto);
    }
}
