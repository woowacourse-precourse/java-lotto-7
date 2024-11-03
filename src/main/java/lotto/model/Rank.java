package lotto.model;

import static lotto.exception.ErrorMessage.NOT_EXIST_RANK_STATE;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int sameCount;
    private final int reward;

    Rank(int sameCount, int reward) {
        this.sameCount = sameCount;
        this.reward = reward;
    }

    public static Rank getRank(int sameCount, boolean isBonusNumberWinning) {
        Rank rank = Arrays.stream(values())
                .filter(value -> value.sameCount == sameCount)
                .findAny()
                .orElseThrow(() -> new IllegalStateException(NOT_EXIST_RANK_STATE.getMessage()));
        if (rank == SECOND && !isBonusNumberWinning) {
            rank = THIRD;
        }
        return rank;
    }

    public int getReward() {
        return reward;
    }
}
