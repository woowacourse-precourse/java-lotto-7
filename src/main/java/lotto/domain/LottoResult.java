package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers(){
        return new ArrayList<>(winningNumbers);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
