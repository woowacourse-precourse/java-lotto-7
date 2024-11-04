package lotto.view;

import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumbersRequest;

public interface InputView {
    PurchaseAmountRequest readPurchaseAmount();

    WinningNumbersRequest readWinningNumbers();
}
