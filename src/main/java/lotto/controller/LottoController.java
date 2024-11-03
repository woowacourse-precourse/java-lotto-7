package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.Payment;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {
    }

    public LottoPaper purchaseLottoPaper(final Payment payment) {
        LottoPaper lottoPaper = LottoPaper.makeLottoPaper(payment.getLottoCount());
        OutputView.printLottoPaperMessage(lottoPaper);
        return lottoPaper;
    }

}


