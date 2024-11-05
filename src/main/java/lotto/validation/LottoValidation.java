package lotto.validation;

import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoValidation {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> validateWinningNumbers(String winningNumbersInput) {
        validateEmptyOrBlank(winningNumbersInput);
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);

        validateDuplicateWinningNumbers(winningNumbers);
        validateWinningNumberRange(winningNumbers);

        return winningNumbers;
    }

    public static int validateBonusNumber(String bonusNumberInput) {
        validateEmptyOrBlank(bonusNumberInput);
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        bonusNumberRange(bonusNumber);

        return bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(LottoErrorMessage.DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void bonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new LottoException(LottoErrorMessage.NUMBER_OUT_OF_RANGE);
        }
    }

    private static int parseBonusNumber(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }

    private static void validateEmptyOrBlank(String input) {
        if (input.strip().isBlank()) {
            throw new LottoException(LottoErrorMessage.EMPTY_OR_BLANK_INPUT);
        }
    }

    private static List<Integer> parseWinningNumbers(String winningNumbersInput) {
        return List.of(winningNumbersInput.split(","))
                .stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new LottoException(LottoErrorMessage.DUPLICATE_WINNING_NUMBERS);
        }
    }

    private static void validateWinningNumberRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new LottoException(LottoErrorMessage.NUMBER_OUT_OF_RANGE);
            }
        }
    }
}