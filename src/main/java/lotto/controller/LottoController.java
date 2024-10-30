package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.utils.LottoExceptionUtils;
import lotto.view.InputView;

public class LottoController {

    public void runLotto() {
        int lottoPurchaseAmount = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::inputLottoPurchaseAmount);
        Lotto wonLotto = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::wonLottoNumbers);
        BonusNumber bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);
    }
}
