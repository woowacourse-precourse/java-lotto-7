package lotto;

import java.util.List;

public class LottoResult {
    private final Integer matchedNumberCount;
    private final boolean isBonusMatched;
    private Integer rank;

    public LottoResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        this.matchedNumberCount = (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();

        this.isBonusMatched = lottoNumbers.contains(bonusNumber);

        calculateRank();
    }

    private void calculateRank() {
        this.rank = 0;
        if (matchedNumberCount == 6) {
            this.rank = 1;
        }
        if (matchedNumberCount == 5) {
            this.rank = 2;
        }
        if (matchedNumberCount == 5 && !isBonusMatched) {
            this.rank = 3;
        }
        if (matchedNumberCount == 4) {
            this.rank = 4;
        }
        if (matchedNumberCount == 3) {
            this.rank = 5;
        }
    }

    public Integer getRank() {
        return rank;
    }
}
