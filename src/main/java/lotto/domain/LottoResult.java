package lotto.domain;

import java.util.List;

public class LottoResult {
    private final Rank rank;

    private LottoResult(Rank rank) {
        this.rank = rank;
    }

    public static LottoResult of(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        boolean hasBonus = lotto.containsBonusNumber(bonusNumber);
        Rank rank = Rank.getRank(matchCount, hasBonus);
        return new LottoResult(rank);
    }

    public int getWinnings() {
        return rank.getWinnings();
    }

    public Rank getRank() {
        return rank;
    }
}