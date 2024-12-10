package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = parseAndValidateWinningNumbers(input);
    }

    public LottoRank calculateRank(Lotto lotto, BonusNumber bonusNumber) {
        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean matchBonus = lotto.includesBonusNumber(bonusNumber);
        return LottoRank.findByMatchCountAndBonus(matchCount, matchBonus);
    }

    private List<Integer> parseAndValidateWinningNumbers(String input) {
        validateInputIsNotNull(input);
        List<String> splitInput = splitInput(input);
        List<Integer> numbers = parseToIntegerList(splitInput);
        validateNumberCount(splitInput);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
        return numbers;
    }

    private void validateInputIsNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessages.NULL_WINNING_NUMBER);
        }
    }

    private List<String> splitInput(String input) {
        return Arrays.asList(input.split(",", -1));
    }

    private void validateNumberCount(List<String> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE || numbers.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private List<Integer> parseToIntegerList(List<String> splitInput) {
        return splitInput.stream()
                .map(this::parseInteger)
                .collect(Collectors.toList());
    }

    private Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_INPUT_ERROR);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < LottoConstants.LOTTO_MIN_NUMBER || num > LottoConstants.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}

