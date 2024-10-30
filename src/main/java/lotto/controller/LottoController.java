package lotto.controller;

import java.util.List;
import lotto.utils.LottoExceptionUtils;
import lotto.view.InputView;

public class LottoController {

    public void runLotto() {
        int lottoPurchaseAmount = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::inputLottoPurchaseAmount);
        String wonLottoNumbersString = LottoExceptionUtils.runUntilNoneLottoException(
                InputView::inputWonLottoNumbers);
        List<Integer> parsedWonLottoNumbers = InputView.parseWonLottoNumbers(wonLottoNumbersString);
        int bonusNumber = LottoExceptionUtils.runUntilNoneLottoException(InputView::inputBonusNumber);
    }
}
