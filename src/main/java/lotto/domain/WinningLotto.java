package lotto.domain;

import java.util.List;

public class WinningLotto {

    public static final int SECOND_RANK_MATCH_COUNT = 5;

    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        validateBonusNumberDuplicated(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        int matchingCount = 0;

        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }

    public boolean isBonusMatch(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto);
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (matchCount == SECOND_RANK_MATCH_COUNT && lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public void validateBonusNumberDuplicated(Lotto lotto, Integer bounsNumber) {
        List<Integer> winningNumbers = lotto.getNumbers();
        if (winningNumbers.contains(bounsNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
