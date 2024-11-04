package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.WINNING;
import static lotto.constants.LottoConstants.BONUS;
import static lotto.constants.LottoConstants.INPUT_DELIMITER;
import static lotto.constants.LottoConstants.NUMBERS;
import static lotto.constants.LottoConstants.LENGTH_BY_NUMBER_TYPE;
import static lotto.constants.LottoConstants.RANDOM_MIN;
import static lotto.constants.LottoConstants.RANDOM_MAX;

public class NumbersValidator {
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Integer> bonusNumber = new ArrayList<>();

    public void validateWinningNumbers(String input) {
        this.winningNumbers = parseNumbers(input);
        validateNumbers(WINNING, winningNumbers);
    }

    public void validateBonusNumber(String input) {
        this.bonusNumber = parseNumbers(input);
        validateNumbers(BONUS, bonusNumber);
        validateBonusNumberUnique(bonusNumber);
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(INPUT_DELIMITER, -1))
                .peek(this::validateNoSpace)
                .peek(this::validateIsNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumbers(String type, List<Integer> numbers) {
        validateLength(type, numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_NUMBER.getMessage(NUMBERS));
        }
    }

    private void validateNoSpace(String input) {
        if (!input.equals(input.strip())) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_NO_SPACE.getMessage(NUMBERS));
        }
    }

    private void validateLength(String type, List<Integer> numbers) {
        int targetLength = LENGTH_BY_NUMBER_TYPE.get(type);
        if (numbers.size() != targetLength) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_TARGET_LENGTH.getMessage(type, targetLength));
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_UNIQUE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < RANDOM_MIN || number > RANDOM_MAX) {
                throw new IllegalArgumentException(LottoErrorMessages.MUST_BE_RANGE.getMessage());
            }
        }
    }

    private void validateBonusNumberUnique(List<Integer> numbers) {
        List<Integer> combinedNumbers = new ArrayList<>(winningNumbers);
        combinedNumbers.addAll(numbers);
        validateUnique(combinedNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    public List<Integer> getBonusNumber() {
        return new ArrayList<>(bonusNumber);
    }
}
