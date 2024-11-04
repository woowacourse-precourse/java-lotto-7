package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.BLANK_WINNING_NUMBERS;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_DUPLICATE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_INVALID_SIZE;
import static lotto.exception.ErrorBase.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.exception.ErrorBase.WINNING_NUMBERS_NON_NUMERIC;
import static lotto.util.CommonValidator.parseIntegerList;
import static lotto.util.CommonValidator.validateNoDuplicates;
import static lotto.util.CommonValidator.validateNumberRange;
import static lotto.util.CommonValidator.validateSize;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.util.CommonValidator.validateNotBlank;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    private static final String DELIMITER = ",";

    public static List<Integer> validate(String winningNumbers) {
        validateNotBlank(winningNumbers, BLANK_WINNING_NUMBERS.getMessage());
        List<Integer> parsedWinningNumbers = parseIntegerList(winningNumbers, DELIMITER, WINNING_NUMBERS_NON_NUMERIC.getMessage());

        validateSize(parsedWinningNumbers, LOTTO_NUMBERS_COUNT);
        validateNoDuplicates(parsedWinningNumbers);
        validateNumberRange(parsedWinningNumbers, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);

        return parsedWinningNumbers;
    }
}
