package lotto.lotto;

import java.util.Arrays;

public enum MatchingCondition {
    SIX(6, BonusMatchedStatus.DOES_NOT_REQUIRE),
    FIVE_AND_BONUS(5, BonusMatchedStatus.REQUIRE_AND_MATCHED),
    FIVE(5, BonusMatchedStatus.REQUIRE_AND_UNMATCHED),
    FOUR(4, BonusMatchedStatus.DOES_NOT_REQUIRE),
    THREE(3, BonusMatchedStatus.DOES_NOT_REQUIRE),
    FAILURE(-1, BonusMatchedStatus.DOES_NOT_REQUIRE);

    enum BonusMatchedStatus {
        REQUIRE_AND_MATCHED {
            @Override
            boolean doesBonusMatched(boolean doesBonusMatched) {
                return doesBonusMatched;
            }
        },
        REQUIRE_AND_UNMATCHED {
            @Override
            boolean doesBonusMatched(boolean doesBonusMatched) {
                return !doesBonusMatched;
            }
        },
        DOES_NOT_REQUIRE {
            @Override
            boolean doesBonusMatched(boolean doesBonusMatched) {
                return true;
            }
        },
        ;

        abstract boolean doesBonusMatched(boolean doesBonusMatched);
    }

    private final int matchingCount;
    private final BonusMatchedStatus bonusMatchedStatus;

    MatchingCondition(int matchingCount, BonusMatchedStatus bonusMatchedStatus) {
        this.matchingCount = matchingCount;
        this.bonusMatchedStatus = bonusMatchedStatus;
    }

    public static MatchingCondition findByMatchingResult(int matchingCount, boolean doesBonusMatched) {
        return Arrays.stream(values())
                .filter(condition -> condition.isSameMatchingCount(matchingCount))
                .filter(condition -> condition.doesBonusMatched(doesBonusMatched))
                .findFirst()
                .orElse(FAILURE);
    }

    private boolean isSameMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    private boolean doesBonusMatched(boolean doesBonusMatched) {
        return bonusMatchedStatus.doesBonusMatched(doesBonusMatched);
    }
}
