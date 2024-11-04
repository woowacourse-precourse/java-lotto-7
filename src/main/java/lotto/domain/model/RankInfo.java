package lotto.domain.model;

import java.util.Objects;

public class RankInfo {
    private final int rank;
    private final int matchCount;
    private final int prizeAmount;
    private final String description;
    private final boolean hasBonusBall;

    public RankInfo(int rank, int matchCount, int prizeAmount, String description, boolean hasBonusBall) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
        this.hasBonusBall = hasBonusBall;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankInfo rankInfo)) return false;
        return rank == rankInfo.rank && matchCount == rankInfo.matchCount &&
                prizeAmount == rankInfo.prizeAmount && hasBonusBall == rankInfo.hasBonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, matchCount, prizeAmount, hasBonusBall);
    }
}
