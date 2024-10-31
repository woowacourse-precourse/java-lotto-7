package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTickets;
import lotto.utils.LottoExceptionUtils;
import lotto.utils.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void runLotto() {
        LottoPrice lottoPurchaseAmount = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputLottoPrice);
        LottoTickets lottoTickets = LottoGenerator.generateLottoTickets(lottoPurchaseAmount.getCanPurchaseLottoCount());
        OutputView.printLottoTickets(lottoTickets);

        Lotto wonLotto = LottoExceptionUtils.runUntilNoneLottoException(InputView::wonLottoNumbers);
        BonusNumber bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);
    }
}
