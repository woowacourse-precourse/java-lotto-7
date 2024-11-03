package lotto.model.winningResult;

import static lotto.model.lotto.LotteryRule.MATCHING_AMOUNT_WITH_BONUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum WinningRank {
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

    WinningRank(int rank, int matchingAmount, boolean withBonusNumber, int price) {
        this.rank = rank;
        this.matchingAmount = matchingAmount;
        this.withBonusNumber = withBonusNumber;
        this.price = price;
    }

    public static WinningRank determineRank(int matchingAmount, boolean matchesBonusNumber) {
        for (WinningRank winningRank : WinningRank.values()) {
            if (matchingAmount == winningRank.matchingAmount) {
                return fromMatchingAmountAndBonusNumber(winningRank, matchingAmount, matchesBonusNumber);
            }
        }
        return FAIL;
    }

    public static List<WinningRank> findRanksExceptFail() {
        List<WinningRank> winningRanks = new ArrayList<>(List.of(WinningRank.values()));
        winningRanks.remove(WinningRank.FAIL);
        return Collections.unmodifiableList(winningRanks);
    }

    private static WinningRank fromMatchingAmountAndBonusNumber(WinningRank winningRank, int matchingAmount,
                                                                boolean matchesBonusNumber) {
        if (matchingAmount == MATCHING_AMOUNT_WITH_BONUS) {
            if (matchesBonusNumber) {
                return WinningRank.SECOND;
            }
            return WinningRank.THIRD;
        }
        return winningRank;
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
}
