package lotto.model;

import static lotto.enums.ErrorCode.DUPLICATE_BONUS_NUMBER;
import static lotto.enums.ErrorCode.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.enums.ErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.enums.ErrorCode.NON_NUMERIC_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final String DELIMITER = ",";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");


    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(String numbersInput, String bonusInput) {
        List<Integer> numbers = parseNumbersInput(numbersInput);
        validateNumbers(numbers);

        int bonusNumber = parseBonusInput(bonusInput);
        validateBonusNumber(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> parseNumbersInput(String input) {
        String[] splitInput = input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitInput) {
            checkIsNumber(num);
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private int parseBonusInput(String bonusInput) {
        checkIsNumber(bonusInput);
        return Integer.parseInt(bonusInput);
    }

    private void checkIsNumber(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NON_NUMERIC_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkUniqueNumbers(numbers);
        checkNumbersRange(numbers);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        checkNumbersRange(bonusNumber);
        checkBonusNotDuplicate(numbers, bonusNumber);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkNumbersRange(number);
        }
    }

    private void checkNumbersRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void checkBonusNotDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
