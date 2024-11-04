package lotto;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(List<String> bonusNumbers, List<String> winningNumbers) {
        validateBonusNumber(bonusNumbers, winningNumbers);
        this.number = Integer.parseInt(bonusNumbers.get(0).trim());
    }

    private static void validateBonusNumber(List<String> bonusNumbers, List<String> winningNumbers) {
        if (bonusNumbers.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_COUNT.getMessage());
        }

        String bonus = bonusNumbers.get(0);

        if (isDuplicateBonus(bonus, winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }

        WinningNumbers.validateNumber(bonus);
    }

    private static boolean isDuplicateBonus(String bonus, List<String> winningNumbers) {
        return winningNumbers.contains(bonus);
    }

    public int getNumber() {
        return number;
    }
}
