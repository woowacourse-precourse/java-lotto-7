package lotto.model.winlotto;

import lotto.model.Lotto;

import java.util.Set;

/** 우승 로또 번호, 보너스 번호를 보관하며 일치 여부를 판단한다. */
public class WinLotto {
    
    private final Set<Integer> basicNumber;
    
    private final int bonusNumber;
    
    public WinLotto(BasicWinLottoNumbers numbers, BonusWinLottoNumber bonusNumber) {
        this.basicNumber = numbers.get();
        this.bonusNumber = bonusNumber.get();
    }
    
    public int getMatchCount(Lotto lotto) {
        Set<Integer> matchNumbers = lotto.getCommonNumbers(basicNumber);
        return matchNumbers.size();
    }
    
    public boolean getBonusMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
    
}
