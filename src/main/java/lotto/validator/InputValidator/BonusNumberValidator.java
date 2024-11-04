package lotto.validator.InputValidator;

import java.math.BigInteger;
import java.util.List;
import lotto.validator.ValidatorUtils;

public class BonusNumberValidator implements InputValidator<Integer> {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public Integer validate(String input) {
        BigInteger bigIntValue = ValidatorUtils.validateBigInteger(input);  // 숫자 형식인지 파악 후 BigInteger 변환
        int bonusNumber = ValidatorUtils.validateIntRange(bigIntValue);      // int 범위 검증
        checkBonusNumberRange(bonusNumber);                                 // 1~45 범위 검증
        return bonusNumber;
    }


    // 보너스 번호의 유효 범위 확인 (1 ~ 45 사이여야 함)
    private static void checkBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1과 45 사이여야 합니다.");
        }
    }

    public static void checkDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
