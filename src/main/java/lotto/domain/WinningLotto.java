package lotto.domain;

import lotto.component.Lotto;
import lotto.constant.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        //vliad
        validateWinningNumbers(lotto.getNumbers(), bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validateWinningNumbers(List<Integer> numbers, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        uniqueNumbers.add(bonusNumber);
        if(uniqueNumbers.size() != LottoConstants.WINNING_LOTTO_NUMBERS_COUNT){
            throw new IllegalArgumentException();
        }
        if(bonusNumber < LottoConstants.MIN_RANGE_NUMBER || bonusNumber > LottoConstants.MAX_RANGE_NUMBER){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
