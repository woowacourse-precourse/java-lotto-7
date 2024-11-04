package lotto.validator;

import lotto.Exception.WinningNumberException;

import java.util.List;
import java.util.stream.Stream;

import static lotto.Exception.LottoExceptionType.*;
import static lotto.utils.LottoRules.*;
import static lotto.utils.TextUtils.*;

public class WinningNumberValidator implements Validator {
    private static final String COMMA_REGEX = ",";

    @Override
    public void validate(String text) throws WinningNumberException {
        validateText(text);

        List<String> splitText = Stream.of(text.split(COMMA_REGEX))
                .map(String::trim)
                .toList();
        validateSplitTexts(splitText);

        List<Integer> splitNumbers = splitText.stream()
                .map(Integer::parseInt)
                .toList();

        validateSplitNumbers(splitNumbers);
    }


    private void validateText(String text) throws WinningNumberException {
        if (isNullOrEmpty(text)) {
            throw new WinningNumberException(LOTTO_NUMBER_EMPTY_ERROR);
        }
    }

    private void validateSplitTexts(List<String> splitText) throws WinningNumberException {
        for (String text : splitText) {
            if (isNullOrEmpty(text)) {
                throw new WinningNumberException(LOTTO_NUMBER_EMPTY_ERROR);
            }
            if (!isNumber(text)) {
                throw new WinningNumberException(LOTTO_NUMBER_NAN_ERROR);
            }
        }
    }

    private void validateSplitNumbers(List<Integer> splitNumbers) throws WinningNumberException {
        for (Integer number : splitNumbers) {
            if (!isValidRange(number)) {
                throw new WinningNumberException(LOTTO_NUMBER_RANGE_ERROR);
            }
        }

        if (isDuplicateNumbers(splitNumbers)) {
            throw new WinningNumberException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }

        if (!isValidCountNumbers(splitNumbers)) {
            throw new WinningNumberException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private boolean isValidRange(Integer number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }

    private boolean isDuplicateNumbers(List<Integer> splitText) {
        return splitText.size() != splitText.stream().distinct().count();
    }

    private boolean isValidCountNumbers(List<Integer> splitNumbers) {
        return splitNumbers.size() == LOTTO_NUMBER_SIZE;
    }
}
