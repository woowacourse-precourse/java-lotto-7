package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumber(int number){
        return number==bonusNumber;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
}
