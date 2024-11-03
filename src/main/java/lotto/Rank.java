package lotto;

import java.util.Arrays;

public enum Rank {
    _NOT_WINNER(0, false, 0),
    _5TH_WINNER(3, false, 5000),
    _4TH_WINNER(4, false, 50000),
    _3RD_WINNER(5, false, 1500000),
    _2ND_WINNER(5, true, 30000000),
    _1ST_WINNER(6, false, 2000000000),
    ;

    private final int matchCount;
    private final boolean isContainBonusNumber;
    private final int prize;

    Rank(int matchCount, boolean isContainBonusNumber, int prize) {
        this.matchCount = matchCount;
        this.isContainBonusNumber = isContainBonusNumber;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean bonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.isContainBonusNumber == bonusNumber)
                .findFirst()
                .orElse(_NOT_WINNER);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isContainBonusNumber() {
        return isContainBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
