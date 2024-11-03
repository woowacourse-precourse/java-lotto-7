package lotto.domain;

import lotto.Lotto;

public class WinningLotto {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank determineRank(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        boolean hasBonus = checkHasBonus(lotto);
        return Rank.of(matchCount, hasBonus);
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningNumbers) {
        validateRange(bonusNumber);
        validateNotDuplicate(bonusNumber, winningNumbers);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNotDuplicate(int bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.get().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.get().stream()
                .filter(winningNumbers.get()::contains)
                .count();
    }

    private boolean checkHasBonus(Lotto lotto) {
        return lotto.get().contains(bonusNumber);
    }
}
