package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumbersValidatorConstant;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class LottoNumbersValidator {
    public void validate(String lottoNumbersInput) {
        if (!isOnlyNumbersAndCommas(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBERS_AND_COMMAS_LOTTO_NUMBERS.getMessage());
        }
        if (isInValidFormat(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_LOTTO_NUMBERS.getMessage());
        }
        if (isNotSixNumbers(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_LOTTO_NUMBERS.getMessage());
        }
        if (isOutOfRangeNumber(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
        }
        if (isDuplicateNumber(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private boolean isOnlyNumbersAndCommas(String lottoNumbersInput) {
        return lottoNumbersInput.matches("^[0-9,]+");
    }

    private boolean isInValidFormat(String lottoNumbersInput) {
        return lottoNumbersInput.matches("^,.*|.*,,.*|.*,$");
    }

    private boolean isNotSixNumbers(String lottoNumbersInput) {
        return lottoNumbersInput.split(",").length !=
                LottoNumbersValidatorConstant.LOTTO_NUMBERS_LENGTH.getValue();
    }

    private boolean isOutOfRangeNumber(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        BigInteger minNumber = BigInteger.valueOf(
                LottoNumbersValidatorConstant.MIN_LOTTO_NUMBER.getValue());
        BigInteger maxNumber = BigInteger.valueOf(
                LottoNumbersValidatorConstant.MAX_LOTTO_NUMBER.getValue());

        for (String number : numbers) {
            BigInteger num = new BigInteger(number);

            if (num.compareTo(minNumber) < 0 || num.compareTo(maxNumber) > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateNumber(String lottoNumbersInput) {
        Set<String> uniqueNumbers = new HashSet<>();
        String[] numbers = lottoNumbersInput.split(",");

        for (String number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}
