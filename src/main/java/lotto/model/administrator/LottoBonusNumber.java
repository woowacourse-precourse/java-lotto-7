package lotto.model.administrator;

import static lotto.util.LottoConstant.LOTTO_NUMBER_END_WITH;
import static lotto.util.LottoConstant.LOTTO_NUMBER_START_WITH;

import lotto.exception.administrator.OutOfRangeLottoNumberException;
import lotto.util.ValidateUtil;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(String bonusNumberInput) {
        bonusNumber = parseToString(bonusNumberInput);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int parseToString(String bonusNumberInput) {
        ValidateUtil.validateNumber(bonusNumberInput);

        try {
            int result = Integer.parseInt(bonusNumberInput);
            validateRange(result);
            return result;
        } catch (NumberFormatException e) {
            throw new OutOfRangeLottoNumberException();
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_NUMBER_START_WITH.getNumber() ||
                number > LOTTO_NUMBER_END_WITH.getNumber()) {
            throw new OutOfRangeLottoNumberException();
        }
    }
}
