package lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(final List<Integer> numbers, final int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<WinningStatus> compareNumbersAndBonusNumber(final List<Lotto> lottos) {
        return lottos.stream()
                .map(this::createWinningStatus)
                .toList();
    }

    private WinningStatus createWinningStatus(final Lotto lotto) {
        final int matchedNumberCount = lotto.countMatchedNumber(numbers);
        final boolean isBonusNumberMatched = lotto.isMatchedBonusNumber(bonusNumber);
        return new WinningStatus(matchedNumberCount, isBonusNumberMatched);
    }
}
