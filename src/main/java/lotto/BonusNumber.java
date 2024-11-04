package lotto;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<Integer> bonusNumbers, WinningNumbers winningNumbers) {
        validateBonusNumber(bonusNumbers, winningNumbers);
        this.number = bonusNumbers.get(0);
    }

    private static void validateBonusNumber(List<Integer> bonusNumbers, WinningNumbers winningNumbers) {

        if (bonusNumbers.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }

        List<Integer> winning = winningNumbers.getNumbers();
        int bonus = validateNumber(bonusNumbers.get(0));

        if (isDuplicateBonus(bonus, winning)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean isDuplicateBonus(int bonus, List<Integer> winning) {
        return winning.contains(bonus);
    }

    public static int validateNumber(int bonus) {
        if (bonus < LottoRules.MIN_NUMBER || bonus > LottoRules.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                            LottoRules.MAX_NUMBER));
        }
        return bonus;
    }

    public int getNumber() {
        return number;
    }
}
