package lotto;

import static lotto.LottoConstants.*;

public class WinningLotto {
    private static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            System.out.println(RANGE_ERROR);
            throw new IllegalArgumentException();
        }

        if (winningNumbers.getNumbers().contains(number)) {
            System.out.println(DUPLICATE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public Rank calculateRank(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        boolean hasBonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.findRank(matchCount, hasBonusMatch);
    }
}
