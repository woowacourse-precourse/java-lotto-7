package lotto.domain;

import static lotto.domain.PrizeInfo.RANK_1_PRIZE;
import static lotto.domain.PrizeInfo.RANK_2_PRIZE;
import static lotto.domain.PrizeInfo.RANK_3_PRIZE;
import static lotto.domain.PrizeInfo.RANK_4_PRIZE;
import static lotto.domain.PrizeInfo.RANK_5_PRIZE;
import static lotto.domain.PrizeInfo.RANK_none_PRIZE;

public enum LottoRank {
    FIRST(RANK_1_PRIZE, 6, false),
    SECOND(RANK_2_PRIZE, 5, true),
    THIRD(RANK_3_PRIZE, 5, false),
    FOURTH(RANK_4_PRIZE, 4, false),
    FIFTH(RANK_5_PRIZE, 3, false),
    NONE(RANK_none_PRIZE, 0, false);

    private long prize;
    private int winningCount;
    private boolean hasBonusNumber;

    private LottoRank(long prize, int winningCount, boolean hasBonusNumber) {
        this.prize = prize;
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public long getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
