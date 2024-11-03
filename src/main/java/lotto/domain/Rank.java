package lotto.domain;

public enum Rank {
    FAILURE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumbers;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int matchingNumbers, boolean hasBonusNumber, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOfLotto(int matchingNumbers, boolean hasBonusNumber) {
        if(matchingNumbers < SECOND.matchingNumbers) {
            hasBonusNumber = false;
        }

        for (Rank rank : values()) {
            if (rank.matchingNumbers == matchingNumbers && rank.hasBonusNumber == hasBonusNumber) {
                return rank;
            }
        }

        return FAILURE;
    }
}
