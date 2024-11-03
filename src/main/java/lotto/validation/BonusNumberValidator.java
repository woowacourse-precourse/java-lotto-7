package lotto.validation;

import lotto.domain.WinningNumber;
import lotto.enums.Message;
import lotto.util.Convertor;

public class BonusNumberValidator {

    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;

    private BonusNumberValidator() {}

    public static void validateRange(int bonusNumber) {
        if (bonusNumber > MAX_NUMBER_RANGE || bonusNumber < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "보너스 번호는 1~45 사이의 숫자를 입력해야 합니다.");
        }
    }

    public static void validateUniqueBonusNumber(WinningNumber winningNumber, String input) {
        int bonusNumber = Convertor.convertToInt(input);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
