package lotto;

import java.util.List;

public class LottoWinningSet implements UniqueNumber {
    List<Integer> winningNumber;
    int bonusNumber;

    public LottoWinningSet(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean hasDuplicateNumber() {
        return (winningNumber.size() != winningNumber.stream().distinct().count()
                || winningNumber.contains(bonusNumber));
    }
}
