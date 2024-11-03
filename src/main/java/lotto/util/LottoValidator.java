package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.enums.DelimiterConstants;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoNumberConstants;

public final class LottoValidator extends Validator {
    private static final String NUMBER_WITH_COMMA_PATTERN = "^[0-9,]+$";

    public static void validateNumbers(String input) {
        checkValidInputString(input);

        List<Integer> numbers = getNumberList(input);
        checkNumberCount(numbers);
        checkAllNumbersInRange(numbers);
        checkDuplicatedNumber(numbers);
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        checkNumberForm(input);

        int number = Integer.parseInt(input);
        checkNumberInRange(number);
        checkDuplicatedWithWinningNumbers(number, winningNumbers);
    }

    private static void checkValidInputString(String input) {
        if (isPatternNotMatched(input, NUMBER_WITH_COMMA_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_INPUT.format());
        }
    }

    private static List<Integer> getNumberList(String input) {
        try {
            return Arrays.stream(input.split(DelimiterConstants.DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_INPUT.format());
        }
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoNumberConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_COUNT.format());
        }
    }

    private static void checkAllNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    private static void checkNumberInRange(int number) {
        if (number < LottoNumberConstants.MIN_VALUE.getValue() || number > LottoNumberConstants.MAX_VALUE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_BOUNDARY.format());
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.format());
        }
    }

    private static void checkDuplicatedWithWinningNumbers(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WITH_WINNING_NUMBERS.format());
        }
    }
}
