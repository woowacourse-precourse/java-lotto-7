package lotto.application.validation;

import static lotto.infrastructure.exception.ErrorCode.*;

import lotto.infrastructure.exception.ErrorCode;

public class InputValidator {

    private final String DELIMITER = ",";
    private final int DOUBLE = 2;

    public void validateAmount(String purchaseAmount) {
        validateNumber(purchaseAmount, INVALID_NUMBER_FORMAT);
    }

    public void validateLotto(String lottoNumbers) {
        validateNoConsecutiveDelimiters(lottoNumbers);
        validateProperDelimiterPosition(lottoNumbers);
//        validateOnlyNumbers(lottoNumbers);
    }

    private void validateNumber(String input, ErrorCode errorCode) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorCode.getMessage());
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

//    private void validateOnlyNumbers(String lottoNumbers) {
//        for (String number : lottoNumbers.split(DELIMITER)) {
//            validateNumber(number, INVALID_LOTTO_NUMBER);
//        }
//    }
}