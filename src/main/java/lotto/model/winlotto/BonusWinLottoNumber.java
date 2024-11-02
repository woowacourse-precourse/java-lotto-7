package lotto.model.winlotto;

import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

import static lotto.utils.StringValidator.containsNotDigit;
import static lotto.utils.StringValidator.isEmpty;
import static lotto.utils.StringValidator.hasBlank;
import static lotto.utils.StringValidator.isOutOfRangeLottoNumber;

public class BonusWinLottoNumber {
    
    private static final String EXCEPTION_MESSAGE_DUPLICATE =
            Constants.EXCEPTION_MESSAGE_PREFIX +
                    "보너스 번호는 기본 당첨 번호와 중복되면 안 됩니다.";
    
    private final int number;
    
    public BonusWinLottoNumber(String bonusNumber, BasicWinLottoNumbers numbers) {
        if (isEmpty(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.toString());
        }
        if (hasBlank(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_INPUT.toString());
        }
        if (containsNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.NO_DIGIT_INPUT.toString());
        }
        if (isOutOfRangeLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage
                    .OUT_OF_LOTTO_NUMBER_RANGE.toString());
        }
        if (isDuplicate(bonusNumber, numbers)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATE);
        }
        this.number = Integer.parseInt(bonusNumber);
    }
    
    private boolean isDuplicate(String numberToValidate,
                                BasicWinLottoNumbers numbers) {
        int number = Integer.parseInt(numberToValidate);
        return numbers.contains(number);
    }

    public int get() {
        return this.number;
    }

}
