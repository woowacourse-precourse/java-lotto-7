package lotto.Domain;

import java.util.List;
import lotto.Enum.LottoPrizeRank;
import lotto.Messages.ErrorMessages;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateWinningNumbers(numbers);
        validateBonusNumber(bonusNumber);
        validateBonusNotDuplicate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_SIZE.message);
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_RANGE.message);
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_DUPLICATE.message);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.BONUS_RANGE.message);
        }
    }

    private void validateBonusNotDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.BONUS_DUPLICATE.message);
        }
    }

    public LottoPrizeRank match(Lotto userLotto) {
        int matchCount = userLotto.matchNumbers(numbers);
        boolean bonusMatch = matchCount == 5 && userLotto.containsNumber(bonusNumber);

        if (matchCount == 6) return LottoPrizeRank.FIRST;
        if (matchCount == 5 && bonusMatch) return LottoPrizeRank.SECOND;
        if (matchCount == 5) return LottoPrizeRank.THIRD;
        if (matchCount == 4) return LottoPrizeRank.FOURTH;
        if (matchCount == 3) return LottoPrizeRank.FIFTH;
        return LottoPrizeRank.MISS;
    }
}