package lotto.view;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.custom.InputException;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.util.InputUtil;

public class InputView {

    public Money getPurchaseAmountFromUser() {
        int amount = InputUtil.readInt();
        validateUnit(amount);
        return Money.of(amount);
    }

    public WinningNumbers getWinningNumberFromUser() {
        return WinningNumbers.of(InputUtil.readIntegerList());
    }

    public int getBonusNumberFromUser() {
        return InputUtil.readInt();
    }

    private boolean validateUnit(int convertedInput) {
        if (isDevidedUnit(convertedInput)) {
            throw new LottoGameException(InputException.INVALID_UNIT);
        }
        return true;
    }

    private boolean isDevidedUnit(int convertedInput) {
        return convertedInput % LottoGameConfig.LOTTO_PRICE_UNIT != 0;
    }
}
