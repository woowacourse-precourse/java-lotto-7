package lotto.view.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningCondition {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000);

    private final int rank;
    private final int winningNumberCount;
    private final boolean mustIncludeBonusNumber;
    private final int rewardAmount;

    WinningCondition(int rank, int winningNumberCount, boolean mustIncludeBonusNumber, int rewardAmount) {
        this.rank = rank;
        this.winningNumberCount = winningNumberCount;
        this.mustIncludeBonusNumber = mustIncludeBonusNumber;
        this.rewardAmount = rewardAmount;
    }

    public static List<WinningCondition> getAllConditions() {
        return Arrays.asList(values());
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }

    public boolean mustIncludeBonusNumber() {
        return mustIncludeBonusNumber;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }
}
