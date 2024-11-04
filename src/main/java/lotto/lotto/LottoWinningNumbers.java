package lotto.lotto;

import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> calculateWinningCount(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.calculateMatchCount(winningNumbers))
                .toList();
    }

    public List<Boolean> calculateBonusCheck(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> lotto.containsBonusNumber(bonusNumber))
                .toList();
    }

}
