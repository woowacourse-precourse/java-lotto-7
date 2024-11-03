package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(2000000000L, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000L, "5개 일치 (1,500,000원) - "),
    FOURTH(50000L, "4개 일치 (50,000원) - "),
    FIFTH(5000L, "3개 일치 (5,000원) - "),
    OUT_OF_RANK(0L, null);

    private final long winningAmount;
    private final String description;

    LottoRank(long winningAmount, String description) {
        this.winningAmount = winningAmount;
        this.description = description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public String getDescription() {
        return description;
    }

    public static List<LottoRank> getAllLottoRank(boolean containsOutOfRank) {
        if (containsOutOfRank) {
            return Arrays.asList(OUT_OF_RANK, FIFTH, FOURTH, THIRD, SECOND, FIRST);
        }
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
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
        if (numberMatchingCount == 6) {
            return FIRST;
        }
        if (containsBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }
}
