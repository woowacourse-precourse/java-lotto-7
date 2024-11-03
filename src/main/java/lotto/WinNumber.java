package lotto;

import java.util.Arrays;

public class WinNumber {

    private int[] numbers;
    private int bonusNumber;

    public WinNumber() {
    }

    public void inputWinNumber(String input) {
        String[] winNumbers = input.split(",");
        int[] numbers = new int[winNumbers.length];
        for (int i = 0; i < winNumbers.length; i++) {
            numbers[i] = Integer.parseInt(winNumbers[i].trim());
        }

        this.numbers = validateWinNumber(numbers);
    }

    private int[] validateWinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        if (numbers.length != 6) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        if (Arrays.stream(numbers).anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (Arrays.stream(numbers).distinct().count() != numbers.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }

        return numbers;
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
