package lotto.view.validation;

import static lotto.service.exception.LottoExceptionMessage.INVALID_WINNING_NUMBERS;
import static lotto.service.exception.LottoExceptionMessage.WINNING_NUMBERS_DUPLICATED;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.service.exception.LottoException;

public class WinningNumbersValidator {

    private static final String WINNING_NUMBERS_REGEX = "^(?:(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5})?$";
    private static final String SEPARATOR = ",";

    public static List<Integer> validate(String winningNumbers) {
        validateWinningNumbersAndSeparator(winningNumbers);
        validateWinningNumbersDuplicated(winningNumbers);
        return Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumbersAndSeparator(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS_REGEX)) {
            throw new LottoException(INVALID_WINNING_NUMBERS);
        }
    }

    private static void validateWinningNumbersDuplicated(String winningNumbers) {
        List<Integer> list = Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> set = Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        if (list.size() != set.size()) {
            throw new LottoException(WINNING_NUMBERS_DUPLICATED);
        }
    }
}
