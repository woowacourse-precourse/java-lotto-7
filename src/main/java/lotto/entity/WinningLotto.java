package lotto.entity;

import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningNumbers; // 당첨 번호
    private final int bonusNumber; // 보너스 번호

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

        // Rank Enum에서 매칭된 등수를 찾음
        for (Rank rank : Rank.values()) {
            if (rank.isMatched(matchCount, hasBonus)) {
                return rank;
            }
        }

        return Rank.NONE; // 일치하는 등수가 없을 경우 NONE 반환
    }
}
