package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.WinningNumberParser;

public class WinningNumberValidator {

    private static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호의 개수는 6개여야 합니다.";
    private static final String WINNING_NUMBER_IS_POSITIVE = "[ERROR] 당첨 번호는 양의 정수여야 합니다.";
    private static final String INVALID_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 사이의 양의 정수여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATE = "[ERROR] 로또 당첨 번호는 서로 중복되선 안 됩니다.";

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int START_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 45;

    public static void validateWinningNumber(final String winningNumbers) {
        List<String> winningNumber = WinningNumberParser.parseWinningNumber(winningNumbers);

        validateWinningNumberCount(winningNumber);
        winningNumber.forEach(number -> {
            validateWinningNumberIsPositive(number);
            validateWinningNumberRange(number);
        });
        validateWinningNumberDuplicate(winningNumber);
    }

    private static void validateWinningNumberCount(final List<String> winningNumber) {
        if (winningNumber.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private static void validateWinningNumberIsPositive(final String number) {
        if (!number.matches("\\d+") || Long.parseLong(number) <= 0) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_POSITIVE);
        }
    }

    private static void validateWinningNumberRange(final String number) {
        if (Integer.parseInt(number) < START_NUMBER_RANGE || Integer.parseInt(number) > END_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE);
        }
    }

    private static void validateWinningNumberDuplicate(final List<String> winningNumber) {
        Set<String> winningNumberSet = new HashSet<>(winningNumber);
        if (winningNumberSet.size() != winningNumber.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE);
        }
    }
}
