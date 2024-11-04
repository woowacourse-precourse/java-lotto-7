package lotto.service;

import lotto.exception.administrator.NotNumberOrCommaException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;
import lotto.util.ValidateUtil;

import java.util.Arrays;
import java.util.List;

public class ValidationService {

    List<Integer> parseToIntegerWinningNumbers(final String winningNumbersInput) {
        validateInputNumberOrComma(winningNumbersInput);
        return mapToInteger(splitByComma(winningNumbersInput));
    }

    int parseToIntegerBonusNumber(final String bonusNumberInput) {
        ValidateUtil.validateNumber(bonusNumberInput);
        return ValidateUtil.parseToInt(bonusNumberInput, OutOfRangeLottoNumberException::new);
    }

    private void validateInputNumberOrComma(final String value) {
        ValidateUtil.emptyValue(value);

        if (!value.matches("^[\\d,]+$")) {
            throw new NotNumberOrCommaException();
        }
    }

    private List<String> splitByComma(final String value) {
        return Arrays.stream(value.split(",")).toList();
    }

    private List<Integer> mapToInteger(List<String> values) {
        return values.stream()
                .map(str -> ValidateUtil.parseToInt(str, OutOfRangeLottoNumberException::new))
                .toList();
    }
}
