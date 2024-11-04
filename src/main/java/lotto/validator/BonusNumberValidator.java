package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BonusNumberValidator {
    public static void validate(String bonusNumberInput, String[] lottoNumbers) {
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

    private static boolean isValidFormat(String bonusNumberInput) {
        return bonusNumberInput.matches("^(\\+)?[0-9]+");
    }

    private static boolean isOutOfRange(String bonusNumberInput) {
        BigInteger number = new BigInteger(bonusNumberInput);
        BigInteger min_number = BigInteger.valueOf(
                LottoConstant.MIN_LOTTO_NUMBER.getValue());
        BigInteger max_number = BigInteger.valueOf(
                LottoConstant.MAX_LOTTO_NUMBER.getValue());

        return number.compareTo(min_number) < 0 || number.compareTo(max_number) > 0;
    }

    private static boolean hasDuplicatedNumber(String bonusNumber, String[] lottoNumbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
        return !uniqueNumbers.add(bonusNumber);
    }
}
