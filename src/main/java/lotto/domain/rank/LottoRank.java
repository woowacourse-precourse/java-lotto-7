package lotto.domain.rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    private final int neededCount;
    private final BonusCondition bonusCondition;

    LottoRank(int rewardAmount, int neededCount, BonusCondition bonusCondition) {
        this.rewardAmount = rewardAmount;
        this.neededCount = neededCount;
        this.bonusCondition = bonusCondition;
    }

    public static Optional<LottoRank> findBy(int sameNumberCount, boolean bonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.neededCount == sameNumberCount)
                .filter(rank -> rank.bonusCondition.isSatisfiedBy(bonusMatched))
                .findAny();
    }

    public static List<LottoRank> getRanksOrderByReward() {
        return Arrays.stream(LottoRank.values())
                .sorted(Comparator.comparingInt(rank -> rank.rewardAmount))
                .toList();
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public int getNeededCount() {
        return neededCount;
    }

    public BonusCondition getBonusCondition() {
        return bonusCondition;
    }

    public enum BonusCondition {

        NOT_APPLICABLE(bonusMatched -> true),
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
