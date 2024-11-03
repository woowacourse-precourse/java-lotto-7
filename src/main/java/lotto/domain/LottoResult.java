package lotto.domain;

import java.util.List;

public class LottoResult {
    private final int matchingCount;
    private final boolean bonusMatch;

    public LottoResult(List<Integer> winningNumbers, Lotto lotto, int bonus) {
        this.matchingCount = (int) winningNumbers.stream()
                .filter(lotto.lottoNumbers()::contains).count();
        this.bonusMatch = lotto.lottoNumbers().contains(bonus);
    }

    public int matchingCount() {
        return matchingCount;
    }
    public boolean bonusMatch() {
        return bonusMatch;
    }
}
