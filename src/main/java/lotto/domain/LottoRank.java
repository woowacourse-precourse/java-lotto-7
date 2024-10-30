package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum LottoRank {

    FIRST(2_000_000_000, 6, BonusCondition.NOT_APPLICABLE),
    SECOND(30_000_000, 5, BonusCondition.MATCHED),
    THIRD(1_500_000, 5, BonusCondition.NOT_MATCHED),
    FOURTH(50_000, 4, BonusCondition.NOT_APPLICABLE),
    FIFTH(5_000, 3, BonusCondition.NOT_APPLICABLE),
    ;

    private final int rewardAmount;
    private final int matchingCount;
    private final BonusCondition bonusCondition;

    LottoRank(int rewardAmount, int matchingCount, BonusCondition bonusCondition) {
        this.rewardAmount = rewardAmount;
        this.matchingCount = matchingCount;
        this.bonusCondition = bonusCondition;
    }

    public static Optional<LottoRank> findBy(int matchingCount, boolean bonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> rank.bonusCondition.isSatisfiedBy(bonusMatched))
                .findAny();
    }

    private enum BonusCondition {

        NOT_APPLICABLE(isBonusMatched -> true),
        MATCHED(bonusMatched -> bonusMatched),
        NOT_MATCHED(bonusMatched -> !bonusMatched),
        ;

        private final Predicate<Boolean> condition;

        BonusCondition(Predicate<Boolean> condition) {
            this.condition = condition;
        }

        public boolean isSatisfiedBy(boolean bonusMatched) {
            return condition.test(bonusMatched);
        }

    }

}
