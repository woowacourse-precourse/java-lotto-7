package lotto;

import java.util.List;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank getLottoRank(Lotto lotto) {
        int matchedCount = countMatchedNumbers(lotto.getNumbers());
        boolean bonusMatched = isBonusMatched(lotto.getNumbers());
        return LottoRank.getRank(matchedCount, bonusMatched);
    }

    private int countMatchedNumbers(List<Integer> numbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean isBonusMatched(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}

