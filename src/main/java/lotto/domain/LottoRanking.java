package lotto.domain;

import lotto.constant.ErrorMessage;

public enum LottoRanking {
    FIFTH(3, 5_000) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber == FIFTH.matchCount;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber == FOURTH.matchCount;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber == THIRD.matchCount && !containBonusNumber;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber == SECOND.matchCount && containBonusNumber;
        }
    },
    FIRST(6, 2_000_000_000) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber == FIRST.matchCount;
        }
    },
    NONE(0, 0) {
        @Override
        public boolean matches(int currentNumber, boolean containBonusNumber) {
            return currentNumber < FIRST.matchCount;
        }
    };

    private final int matchCount;
    private final long reward;

    LottoRanking(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    protected abstract boolean matches(int currentNumber, boolean containBonusNumber);

    public static LottoRanking getRank(int currentNumberCount, boolean containBonusNumber) {
        for (LottoRanking rank : values()) {
            if (rank.matches(currentNumberCount, containBonusNumber)) {
                return rank;
            }
        }
        throw new IllegalStateException(ErrorMessage.INVALID_LOTTO.getMessage());
    }

    public long getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
