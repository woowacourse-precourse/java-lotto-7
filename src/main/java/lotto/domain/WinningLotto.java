package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private final Lotto winninglotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winninglotto, int bonusNumber) {
        this.winninglotto = winninglotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> calculateRanks(LottoTicket lottoTicket) {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        for (Lotto lotto : lottoTicket.getLottos()) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winninglotto.getNumbers()::contains)
                    .count();

            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.findRank(matchCount, hasBonusNumber);

            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }
}
