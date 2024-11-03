package lotto;

import java.util.Arrays;

public class WinNumber {

    private int[] numbers;
    private int bonusNumber;

    public void inputWinNumber(String input) {
        int[] parsedNumbers = parseNumbers(input);
        this.numbers = validateWinNumber(parsedNumbers);
    }

    private int[] parseNumbers(String input) {
        String[] winNumbers = input.split(",");
        int[] numbers = new int[winNumbers.length];
        for (int i = 0; i < winNumbers.length; i++) {
            numbers[i] = Integer.parseInt(winNumbers[i].trim());
        }
        return numbers;
    }

    private int[] validateWinNumber(int[] numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
        return numbers;
    }

    private void validateNumberCount(int[] numbers) {
        if (numbers == null || numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberRange(int[] numbers) {
        if (Arrays.stream(numbers).anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNoDuplicates(int[] numbers) {
        if (Arrays.stream(numbers).distinct().count() != numbers.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public void inputBonusNumber(int number) {
        validateBonusNumber(number);
        this.bonusNumber = number;
    }

    private void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
        if (Arrays.stream(numbers).anyMatch(n -> n == number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
