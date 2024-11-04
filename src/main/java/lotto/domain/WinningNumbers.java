package lotto.domain;

import static lotto.constant.Constant.NUMBERS_RANGE_END;
import static lotto.constant.Constant.NUMBERS_RANGE_START;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    private final BonusNumber bonusNumber;

    public WinningNumbers(String inputNumbers, BonusNumber bonusNumber) {
        List<String> numbersInString = parse(inputNumbers);
        this.numbers = validateInteger(numbersInString);
        validateSixNumbers();
        validateRange();
        validateDuplicated();
        sortNumbers();

        this.bonusNumber = bonusNumber;
        validateBonusDuplicated();
    }

    private List<String> parse(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private List<Integer> validateInteger(List<String> numbersInString) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : numbersInString) {
            try {
                parsedNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return parsedNumbers;
    }

    private void validateSixNumbers() {
        if (numbers.size() != 6) {
            throw new NumberFormatException();
        }
    }

    private void validateRange() {
        boolean isRange = numbers.stream()
                .allMatch(number -> number >= NUMBERS_RANGE_START && number <= NUMBERS_RANGE_END);

        if (!isRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated() {
        Set<Integer> validatedNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!validatedNumbers.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    private void validateBonusDuplicated() {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = numbers;
        winningNumbers.add(bonusNumber.getBonusNumber());
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
