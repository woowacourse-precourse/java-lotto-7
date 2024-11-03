package lotto.model.lotto;

import java.util.Set;

public class LottoWinningNumbers {

    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public LottoWinningNumbers(Set<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

}
