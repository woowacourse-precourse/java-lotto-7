package lotto;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<Integer> numbers, WinningNumbers winningNumbers) {
        validateBonusNumber(numbers, winningNumbers);
        this.number = numbers.getFirst();
    }

    private static void validateBonusNumber(List<Integer> numbers, WinningNumbers winningNumbers) {

        if (numbers.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }

        List<Integer> winningNumberList = winningNumbers.getNumbers();
        int number = validateNumber(numbers.getFirst());

        if (isDuplicateBonus(number, winningNumberList)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean isDuplicateBonus(int number, List<Integer> winning) {
        return winning.contains(number);
    }

    public static int validateNumber(int number) {
        if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                            LottoRules.MAX_NUMBER));
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
