package lotto.model.lottoresult;

import java.util.Arrays;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PrizeLotto;

public enum LottoRank {
    FIRST_PRIZE(1, 6, false, 2_000_000_000),
    SECOND_PRIZE(2, 5, true, 30_000_000),
    THIRD_PRIZE(3, 5, false, 1_500_000),
    FOURTH_PRIZE(4, 4, false, 50_000),
    FIFTH_PRIZE(5, 3, false, 5_000),
    ;
    private final int rank;
    private final int totalMatch;
    private final boolean isBonusMatched;
    private final int prizeMoney;

    LottoRank(int rank, int totalMatch, boolean isBonusMatched, int prizeMoney) {
        this.rank = rank;
        this.totalMatch = totalMatch;
        this.isBonusMatched = isBonusMatched;
        this.prizeMoney = prizeMoney;
    }


    public int getRank() {
        return rank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank from(PrizeLotto prizeLotto, Lotto lotto) {
        int totalMatch = prizeLotto.countWinningLottoMatched(lotto);
        boolean isBonusMatched = prizeLotto.isBonusNumberMatched(lotto);

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.totalMatch == totalMatch)
                .filter(rank -> rank.isBonusMatched == isBonusMatched || !rank.isBonusMatched)
                .findFirst()
                .orElse(null);
    }
}
