package lotto.controller;

import lotto.dto.LottoMatchDTO;
import lotto.dto.WinningNumberDTO;
import lotto.model.Lottos;
import lotto.view.PurchaseAmountView;
import lotto.view.PurchaseLottosView;
import lotto.view.WinningBonusNumberView;
import lotto.view.WinningStatisticView;

public final class LottoController {
    public void run() {
        int purchaseQuantity = PurchaseAmountView.purchaseAmount();
        Lottos purchaseLottos = PurchaseLottosView.purchaseLottos(purchaseQuantity);
        WinningNumberDTO winningNumberDTO = WinningBonusNumberView.winningBonusNumber();
        LottoMatchDTO lottoMatchDTO = new LottoMatchDTO(purchaseLottos, winningNumberDTO);
        WinningStatisticView.winningStatistic(lottoMatchDTO);
    }
}
