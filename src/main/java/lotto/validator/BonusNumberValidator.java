package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumberRangeConstant;
import lotto.constant.LottoNumbersConstant;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// - 예외 조건
//- 당첨 번호와 중복인 경우 (예: 당첨 번호 `1,2,3,4,5,6` 보너스 번호 `1`)
public class BonusNumberValidator {
    public void validate(String bonusNumberInput, String[] lottoNumbers) {
        if (!isValidFormat(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_BONUS_NUMBER.getMessage());
        }
        if (isOutOfRange(bonusNumberInput)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
        }
        if (hasDuplicatedNumber(bonusNumberInput, lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isValidFormat(String bonusNumberInput) {
        return bonusNumberInput.matches("^(\\+)?[0-9]+");
    }

    private boolean isOutOfRange(String bonusNumberInput) {
        BigInteger number = new BigInteger(bonusNumberInput);
        BigInteger min_number = BigInteger.valueOf(
                LottoNumbersConstant.MIN_LOTTO_NUMBER.getValue());
        BigInteger max_number = BigInteger.valueOf(
                LottoNumbersConstant.MAX_LOTTO_NUMBER.getValue());

        return number.compareTo(min_number) < 0 || number.compareTo(max_number) > 0;
    }

    private boolean hasDuplicatedNumber(String bonusNumber, String[] lottoNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
        return !uniqueNumbers.add(bonusNumber);
    }
}
