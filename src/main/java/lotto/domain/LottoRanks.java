package lotto.domain;

import java.util.List;


import static lotto.domain.LottoConstants.LOTTO_1ST_PRIZE;
import static lotto.domain.LottoConstants.LOTTO_2ND_PRIZE;
import static lotto.domain.LottoConstants.LOTTO_3RD_PRIZE;
import static lotto.domain.LottoConstants.LOTTO_4TH_PRIZE;
import static lotto.domain.LottoConstants.LOTTO_5TH_PRIZE;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

public class LottoRanks {
    private final List<LottoRank> ranks;

    public LottoRanks() {
        this.ranks = List.of(
                new LottoRank("5등", LOTTO_5TH_PRIZE, LOTTO_SIZE - 3, false),
                new LottoRank("4등", LOTTO_4TH_PRIZE, LOTTO_SIZE - 2, false),
                new LottoRank("3등", LOTTO_3RD_PRIZE, LOTTO_SIZE - 1, false),
                new LottoRank("2등", LOTTO_2ND_PRIZE, LOTTO_SIZE - 1, true),
                new LottoRank("1등", LOTTO_1ST_PRIZE, LOTTO_SIZE, false)
        );
    }

    public LottoRanks(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public void updateWinningCounts(int matchCount, boolean bonusMatch) {
        for(LottoRank rank : ranks) {
            if(rank.getRequiredMatchCount() == matchCount && rank.getRequiresBonus() == bonusMatch) {
                rank.increaseWinningCount();
            }
        }
    }


    public List<LottoRank> getRanks() {
        return ranks;
    }
}
