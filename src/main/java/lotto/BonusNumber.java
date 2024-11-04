package lotto;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<Integer> numbers, WinningNumbers winningNumbers) {
        validateNumbersCount(numbers);
        validateNumbersDuplication(numbers, winningNumbers);
        this.number = numbers.getFirst();
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoRules.BONUS_NUMBER_REQUIRED) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateNumbersDuplication(List<Integer> numbers, WinningNumbers winningNumbers) {
        List<Integer> winningNumberList = winningNumbers.getNumbers();
        int number = validateNumberInRange(numbers.getFirst());

        if (isDuplicateBonus(number, winningNumberList)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static int validateNumberInRange(int number) {
        if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                            LottoRules.MAX_NUMBER));
        }
        return number;
    }

    private static boolean isDuplicateBonus(int number, List<Integer> winning) {
        return winning.contains(number);
    }

    public int getNumber() {
        return number;
    }
}
