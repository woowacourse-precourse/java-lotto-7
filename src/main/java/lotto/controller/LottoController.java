package lotto.controller;

import java.util.List;
import lotto.utils.ExceptionUtils;
import lotto.view.InputView;

public class LottoController {

    public void runLotto() {
        int lottoPurchaseAmount = ExceptionUtils.runUntilNoneIllegalArgumentException(
                InputView::inputLottoPurchaseAmount);
        String wonLottoNumbersString = ExceptionUtils.runUntilNoneIllegalArgumentException(
                InputView::inputWonLottoNumbers);
        List<Integer> parsedWonLottoNumbers = InputView.parseWonLottoNumbers(wonLottoNumbersString);
        int bonusNumber = ExceptionUtils.runUntilNoneIllegalArgumentException(InputView::inputBonusNumber);
    }
}
