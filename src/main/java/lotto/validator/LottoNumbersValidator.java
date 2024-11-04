package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class LottoNumbersValidator {
    public static void validate(String lottoNumbersInput) {
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
        if (hasDuplicatedNumber(lottoNumbersInput)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean isOnlyNumbersAndCommas(String lottoNumbersInput) {
        return lottoNumbersInput.matches("^[0-9,]+");
    }

    private static boolean isInValidFormat(String lottoNumbersInput) {
        return lottoNumbersInput.matches("^,.*|.*,,.*|.*,$");
    }

    private static boolean isNotSixNumbers(String lottoNumbersInput) {
        return lottoNumbersInput.split(",").length != LottoConstant.LOTTO_NUMBERS_LENGTH.getValue();
    }

    private static boolean isOutOfRangeNumber(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        BigInteger minNumber = BigInteger.valueOf(LottoConstant.MIN_LOTTO_NUMBER.getValue());
        BigInteger maxNumber = BigInteger.valueOf(LottoConstant.MAX_LOTTO_NUMBER.getValue());

        for (String number : numbers) {
            BigInteger num = new BigInteger(number);

            if (num.compareTo(minNumber) < 0 || num.compareTo(maxNumber) > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicatedNumber(String lottoNumbersInput) {
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
