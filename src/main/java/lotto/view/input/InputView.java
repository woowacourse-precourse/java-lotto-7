package lotto.view.input;

import lotto.dto.request.PurchaseAmountDTO;
import lotto.dto.request.WinningLottoBonusNumberDTO;
import lotto.dto.request.WinningLottoNumbersDTO;

public interface InputView {
    PurchaseAmountDTO inputPurchaseAmount();

    WinningLottoNumbersDTO inputWinningLottoNumbers();

    WinningLottoBonusNumberDTO inputWinningLottoBonusNumber();
}
