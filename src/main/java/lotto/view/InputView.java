package lotto.view;

import lotto.dto.BonusNumberRequest;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumbersRequest;

public interface InputView {
    PurchaseAmountRequest readPurchaseAmount();

    WinningNumbersRequest readWinningNumbers();

    BonusNumberRequest readBonusNumber(WinningNumbersRequest winningNumbersRequest);
}
