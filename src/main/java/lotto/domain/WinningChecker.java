package lotto.domain;

import java.util.List;

public class WinningChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningChecker(List<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank checkLotto(Lotto lotto){
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }
}
