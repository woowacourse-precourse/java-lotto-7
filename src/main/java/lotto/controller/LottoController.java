package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.utils.LottoExceptionUtils;
import lotto.view.InputView;

public class LottoController {

    public void runLotto() {
        LottoPrice lottoPurchaseAmount = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::inputLottoPrice);
        Lotto wonLotto = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::wonLottoNumbers);
        BonusNumber bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);
    }
}
