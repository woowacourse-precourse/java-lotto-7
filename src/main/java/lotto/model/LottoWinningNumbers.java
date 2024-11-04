package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
