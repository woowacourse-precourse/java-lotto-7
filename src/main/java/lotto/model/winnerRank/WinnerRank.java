package lotto.model.winnerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum WinnerRank {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    FAIL(6, -1, false, 0);

    private final int rank;
    private final int matchingAmount;
    private final boolean withBonusNumber;
    private final int price;

    WinnerRank(int rank, int matchingAmount, boolean withBonusNumber, int price) {
        this.rank = rank;
        this.matchingAmount = matchingAmount;
        this.withBonusNumber = withBonusNumber;
        this.price = price;
    }

    public static List<WinnerRank> findRanksExceptFail() {
        List<WinnerRank> winnerRanks = new ArrayList<>(List.of(WinnerRank.values()));
        winnerRanks.remove(WinnerRank.FAIL);
        return Collections.unmodifiableList(winnerRanks);
    }

    public static WinnerRank findByRank(int rank) {
        for (WinnerRank winnerRank : WinnerRank.values()) {
            if (rank == winnerRank.rank) {
                return winnerRank;
            }
        }
        return FAIL;
    }

    public int getMatchingAmount() {
        return matchingAmount;
    }

    public int getPrice() {
        return price;
    }

    public int getRank() {
        return rank;
    }

    public boolean isWithBonusNumber() {
        return withBonusNumber;
    }
}
