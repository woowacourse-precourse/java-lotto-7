package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedPrice;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchasedPrice purchasedPrice = new PurchasedPrice(InputView.readPurchasePrice());
        Lotto winningNumbers = new Lotto(InputView.readWinningNumbers());
    }
}
