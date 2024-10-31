package lotto.model.rank;

import static lotto.model.money.Money.FIFTH_RANK_PRIZE;
import static lotto.model.money.Money.FIRST_RANK_PRIZE;
import static lotto.model.money.Money.FOURTH_RANK_PRIZE;
import static lotto.model.money.Money.SECOND_RANK_PRIZE;
import static lotto.model.money.Money.THIRD_RANK_PRIZE;

import java.util.Arrays;
import java.util.function.BiPredicate;
import lotto.model.money.Money;

public enum Rank {

    FIRST(6, (count, bonus) -> count == 6 && !bonus, FIRST_RANK_PRIZE),
    SECOND(5, (count, bonus) -> count == 5 && bonus, SECOND_RANK_PRIZE),
    THIRD(5, (count, bonus) -> count == 5 && !bonus, THIRD_RANK_PRIZE),
    FOURTH(4, (count, bonus) -> count == 4 && !bonus, FOURTH_RANK_PRIZE),
    FIFTH(3, (count, bonus) -> count == 3 && !bonus, FIFTH_RANK_PRIZE),
    NONE(0, (count, bonus) -> count == 6 && !bonus, Money.ZERO),
    ;

    private final Integer matchedCount;
    private final BiPredicate<Integer, Boolean> predicate;
    private final Money prize;

    Rank(final Integer matchedCount, final BiPredicate<Integer, Boolean> predicate, final Money prize) {
        this.matchedCount = matchedCount;
        this.predicate = predicate;
        this.prize = prize;
    }

    public static Rank getRankBy(int matchedCount, boolean bonusNumberMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.predicate.test(matchedCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean enoughCountToBeSecondRank(int matchedCount) {
        return SECOND.matchedCount == matchedCount;
    }
}
