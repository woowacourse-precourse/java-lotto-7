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
        int bonusNumber = InputUtil.readInt();
        validateRange(bonusNumber);
        return bonusNumber;
    }

    private void validateUnit(int convertedInput) {
        if (isDividedUnit(convertedInput)) {
            throw new LottoGameException(InputException.INVALID_UNIT);
        }
    }

    private boolean isDividedUnit(int convertedInput) {
        return convertedInput % LottoGameConfig.LOTTO_PRICE_UNIT != 0;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LottoGameConfig.START_NUMBER || bonusNumber > LottoGameConfig.END_NUMBER) {
            throw new LottoGameException(InputException.INVALID_RANGE);
        }
    }

}
