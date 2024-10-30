package lotto.model;

import lotto.utils.Constants;

import static lotto.utils.StringValidator.validateOnlyDigits;
import static lotto.utils.StringValidator.validateEmpty;
import static lotto.utils.StringValidator.validateHasBlank;


public class BonusWinLottoNumber {
    
    private static final String EXCEPTION_MESSAGE_DUPLICATE =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 보너스 번호는 기본 당첨 번호와 중복되면 안 됩니다.";
    
    private static final String EXCEPTION_MESSAGE_OUT_RANGE =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 보너스 번호는 " + Constants.MIN_LOTTO_NUMBER +
                    "와 " + Constants.MAX_LOTTO_NUMBER + "사이의 정수여야 합니다.";
    
    private final int number;
    
    public BonusWinLottoNumber(String bonusNumber, BasicWinLottoNumbers numbers) {
        try {
            validateEmpty(bonusNumber);
            validateHasBlank(bonusNumber);
            validateOnlyDigits(bonusNumber);
            validateInRange(bonusNumber);
            validateDuplicate(bonusNumber, numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.number = Integer.parseInt(bonusNumber);
    }
    
    private void validateDuplicate(String numberToValidate,
                                   BasicWinLottoNumbers numbers) {
        int number = Integer.parseInt(numberToValidate);
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_DUPLICATE);
        }
    }
    
    private void validateInRange(String numberToValidate) {
        int number = Integer.parseInt(numberToValidate);
        if (number > Constants.MAX_LOTTO_NUMBER || number < Constants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OUT_RANGE);
        }
    }
    
    public int get() {
        return this.number;
    }
}
