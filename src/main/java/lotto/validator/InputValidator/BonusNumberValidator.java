package lotto.validator.InputValidator;

import java.math.BigInteger;
import java.util.List;
import lotto.validator.LottoValidator;
import lotto.validator.ValidatorUtils;

public class BonusNumberValidator implements InputValidator<Integer> {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public Integer validate(String input) {
        throw new UnsupportedOperationException("This validator requires winning numbers for validation.");
    }

    public Integer validate(String input, List<Integer> winningNumbers) {
        BigInteger bigIntValue = ValidatorUtils.validateBigInteger(input);  // 숫자 형식인지 파악 후 BigInteger 변환
        int bonusNumber = ValidatorUtils.validateIntRange(bigIntValue);      // int 범위 검증
        LottoValidator.validateRange(bonusNumber);
        checkDuplicate(winningNumbers, bonusNumber);
        return bonusNumber;
    }


    public static void checkDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
