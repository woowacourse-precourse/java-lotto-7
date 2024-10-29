package lotto.view;

import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.util.InputUtil;

public class InputView {

    public Money getPurchaseAmountFromUser() {
        return Money.of(InputUtil.readInt());
    }

    public WinningNumbers getWinningNumberFromUser() {
        return WinningNumbers.of(InputUtil.readIntegerList());
    }

}
