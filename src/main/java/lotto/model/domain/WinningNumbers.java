package lotto.model.domain;

import lotto.exception.InputErrorMessage;

import java.util.*;

public class WinningNumbers {
    private final static int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    private static void validate(List<Integer> winningNumbers) {
        validateNotEmpty(winningNumbers);
        validateSizeSix(winningNumbers);
        validateDuplicates(winningNumbers);
    }

    private static void validateNotEmpty(List<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateSizeSix(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(InputErrorMessage.OVER_SIZE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> winningNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(InputErrorMessage.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);  // Return a copy for encapsulation
    }
}