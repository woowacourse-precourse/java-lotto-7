package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.service.LottoService;
import lotto.utils.LottoExceptionUtils;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void runLotto() {
        LottoPrice lottoPurchaseAmount = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::inputLottoPrice);
        Lotto wonLotto = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::wonLottoNumbers);
        BonusNumber bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);


    }
}
