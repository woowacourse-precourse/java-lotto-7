package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> lottoWinningResult(LottoTicket lottoTicket) {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(super.getNumbers()::contains)
                    .count();

            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.findRank(matchCount, hasBonusNumber);

            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }
}
