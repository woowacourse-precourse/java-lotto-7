package lotto.util;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$"; // 양의 정수 정규식
    private static final int LOTTO_STANDARD_PRICE = 1000; // 로또 한 장 가격
    private static final int WINNING_NUMBER_COUNT = 6; // 당첨 번호 개수
    private static final int MIN_NUMBER = 1; // 번호 최소값
    private static final int MAX_NUMBER = 45; // 번호 최대값

    public void validatePurchasePrice(String input) {
        validateNotEmpty(input, ErrorMessage.EMPTY_PURCHASE_PRICE);
        validatePositiveInteger(input);
        validateMultipleOfLottoPrice(input);
    }

    public List<Integer> validateWinningNumbers(String input) {
        validateNotEmpty(input, ErrorMessage.EMPTY_WINNING_NUMBERS);
        List<Integer> winningNumbers = convertToList(input);
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        return winningNumbers;
    }

    public int validateBonusNumber(List<Integer> winningNumbers, String input) {
        validateNotEmpty(input, ErrorMessage.EMPTY_BONUS_NUMBER);
        int bonusNumber = parseInteger(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private void validateNotEmpty(String input, ErrorMessage errorMessage) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private void validatePositiveInteger(String input) {
        if (!Pattern.matches(POSITIVE_INTEGER_REGEX, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    private void validateMultipleOfLottoPrice(String input) {
        int amount = Integer.parseInt(input);
        if (amount % LOTTO_STANDARD_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_MULTIPLE.getMessage());
        }
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> convertToList(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(this::parseInteger)
                .collect(Collectors.toList());
    }

    private Integer parseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}