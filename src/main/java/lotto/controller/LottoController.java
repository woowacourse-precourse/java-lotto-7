package lotto.controller;

import lotto.dto.WinningNumber;
import lotto.model.Lottos;
import lotto.view.PurchaseAmountView;
import lotto.view.PurchaseLottosView;
import lotto.view.WinningBonusNumberView;

public final class LottoController {
    public void run() {
        int purchaseQuantity = PurchaseAmountView.purchaseAmount();
        Lottos lottos = PurchaseLottosView.purchaseLottos(purchaseQuantity);
        WinningNumber winningNumber = WinningBonusNumberView.winningBonusNumber();
        System.out.println(winningNumber.winningLotto());
        System.out.println(winningNumber.bonusNumber());
    }
}
