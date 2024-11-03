package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FOURTH(50000L),
    FIFTH(5000L),
    OUT_OF_RANK(0L);

    private final long winningAmount;

    LottoRank(long winningAmount) {
        this.winningAmount = winningAmount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static List<LottoRank> getAllLottoRank() {
        return Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, OUT_OF_RANK);
    }

    public static LottoRank calculateLottoRank(int numberMatchingCount, boolean containsBonusNumber) {
        if (numberMatchingCount < 3) {
            return OUT_OF_RANK;
        }
        if (numberMatchingCount == 3) {
            return FIFTH;
        }
        if (numberMatchingCount == 4) {
            return FOURTH;
        }
        if (numberMatchingCount == 5) {
            return THIRD;
        }
        if (!containsBonusNumber) {
            return SECOND;
        }
        return FIRST;
    }
}
