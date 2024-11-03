package lotto;

import static lotto.infrastructure.exception.ErrorCode.*;

import lotto.infrastructure.exception.ErrorCode;

public class InputValidator {

    private final String DELIMITER = ",";
    private final int DOUBLE = 2;

    public void validateAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount, INVALID_NUMBER_FORMAT);
    }

    public void validateLotto(String lottoNumbers) {
        validateNoConsecutiveDelimiters(lottoNumbers);
        validateProperDelimiterPosition(lottoNumbers);
        validateOnlyNumbers(lottoNumbers);
        validateProperRangeNumber(lottoNumbers);
    }

    private void validateProperRangeNumber(String lottoNumbers) {
        for (String lottoNumber : lottoNumbers.split(DELIMITER)) {
            int number = Integer.parseInt(lottoNumber);
            if (number < 1 || number > 45) {
	throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateNoConsecutiveDelimiters(String lottoNumbers) {
        if (lottoNumbers.contains(DELIMITER.repeat(DOUBLE))) {
            throw new IllegalArgumentException(INVALID_LOTTO_CONSECUTIVE_DELIMITERS.getMessage());
        }
    }

    private void validateProperDelimiterPosition(String lottoNumbers) {
        if (lottoNumbers.charAt(0) == ','
            || lottoNumbers.charAt(lottoNumbers.length() - 1) == ',') {
            throw new IllegalArgumentException(INVALID_LOTTO_DELIMITER_POSITION.getMessage());
        }
    }

    private void validateOnlyNumbers(String lottoNumbers) {
        for (String number : lottoNumbers.split(DELIMITER)) {
            validateIsNumber(number, INVALID_LOTTO_NUMBER);
        }
    }

    private void validateIsNumber(String input, ErrorCode errorCode) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorCode.getMessage());
        }
    }
}