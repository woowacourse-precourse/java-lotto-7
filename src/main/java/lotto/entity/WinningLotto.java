package lotto.entity;

import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Set<Integer> userNumbers) {
        int matchCount = 0;
        boolean hasBonus = userNumbers.contains(bonusNumber);

        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return Rank.getRank(matchCount, hasBonus);
    }
}