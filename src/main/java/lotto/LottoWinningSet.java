package lotto;

import java.util.List;

public class LottoWinningSet implements UniqueNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoWinningSet(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean hasDuplicateNumber() {
        return (winningNumber.size() != winningNumber.stream().distinct().count()
                || winningNumber.contains(bonusNumber));
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningNumber.stream()
                .filter(lotto::hasNumber)
                .toList()
                .size();
    }

    public boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
