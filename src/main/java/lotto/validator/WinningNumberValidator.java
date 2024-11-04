package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.message.ErrorMessage;

public class WinningNumberValidator {
    public static Set<Integer> validateWinningNumber(String[] winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>();
        checkWinningNumbersAmount(winningNumbers);
        for (String winningNumber : winningNumbers) {
            checkNullOrEmptyNumber(winningNumber);
            checkInteger(winningNumber);
            checkValidWinningNumber(winningNumber);
            checkDuplicateWinningNumber(winningNumber, winningNumberSet);
            winningNumberSet.add(Integer.parseInt(winningNumber));
        }
        return winningNumberSet;
    }

    private static void checkNullOrEmptyNumber(String winningNumber) {
        if (winningNumber == null || winningNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_WINNING_NUMBER.getMessage());
        }
    }

    private static void checkInteger(String winningNumber) {
        try {
            Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private static void checkWinningNumbersAmount(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private static void checkValidWinningNumber(String winningNumber) {
        int winningNumberInt = Integer.parseInt(winningNumber);
        if (winningNumberInt > 45 || winningNumberInt < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private static void checkDuplicateWinningNumber(String winningNumber, Set<Integer> winningNumberSet) {
        if (winningNumberSet.contains(Integer.parseInt(winningNumber))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
