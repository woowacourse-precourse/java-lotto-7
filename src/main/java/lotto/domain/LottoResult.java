package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoResult {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(Set<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
