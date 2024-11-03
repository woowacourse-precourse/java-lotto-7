package lotto;

import static lotto.ErrorCode.INVALID_LOTTO_NUMBER;
import static lotto.ErrorCode.INVALID_NUMBER_FORMAT;

public class InputValidator {

    private final String DELIMITER = ",";

    public void validateAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount, INVALID_NUMBER_FORMAT);
    }

    public void validateLotto(String lottoNumbers) {
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