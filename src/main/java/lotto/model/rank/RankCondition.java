package lotto.model.rank;

import static lotto.model.money.Money.FIFTH_RANK_PRIZE;
import static lotto.model.money.Money.FIRST_RANK_PRIZE;
import static lotto.model.money.Money.FOURTH_RANK_PRIZE;
import static lotto.model.money.Money.SECOND_RANK_PRIZE;
import static lotto.model.money.Money.THIRD_RANK_PRIZE;
import static lotto.model.money.Money.ZERO;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import lotto.model.money.Money;

public enum RankCondition {

    FIRST(6, (count, bonus) -> count == 6 && !bonus, FIRST_RANK_PRIZE),
    SECOND(5, (count, bonus) -> count == 5 && bonus, SECOND_RANK_PRIZE),
    THIRD(5, (count, bonus) -> count == 5 && !bonus, THIRD_RANK_PRIZE),
    FOURTH(4, (count, bonus) -> count == 4 && !bonus, FOURTH_RANK_PRIZE),
    FIFTH(3, (count, bonus) -> count == 3 && !bonus, FIFTH_RANK_PRIZE),
    NONE(0, (count, bonus) -> count == 6 && !bonus, ZERO);

    private final Integer matchingCount;
    private final BiPredicate<Integer, Boolean> predicate;
    private final Money prizeAmount;

    RankCondition(final Integer matchingCount, final BiPredicate<Integer, Boolean> predicate, final Money prizeAmount) {
        this.matchingCount = matchingCount;
        this.predicate = predicate;
        this.prizeAmount = prizeAmount;
    }

    public static RankCondition getRankBy(final int matchingCount, final boolean bonusNumberMatched) {
        return Arrays.stream(RankCondition.values())
                .filter(rank -> rank.predicate.test(matchingCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean hasEnoughCountToBeSecondRank(final int matchingCount) {
        return SECOND.matchingCount == matchingCount;
    }

    public static List<RankCondition> valuesExceptNone() {
        return Arrays.stream(RankCondition.values())
                .filter(condition -> condition != NONE)
                .toList();
    }

    public Money calculateReceivableTotalPrizeAmountBy(final int prizeCount) {
        return prizeAmount.multiply(prizeCount);
    }

    public String toStringMessage() {
        if (this == SECOND) {
            String template = "%d개 일치, 보너스 볼 일치 (%s)";
            return generateMessageFrom(template, matchingCount, prizeAmount.toString());
        }
        String template = "%d개 일치 (%s)";
        return generateMessageFrom(template, matchingCount, prizeAmount.toString());
    }

    private String generateMessageFrom(
            final String template,
            final int matchingCount,
            final String prizeAmount) {
        return String.format(template, matchingCount, prizeAmount);
    }
}
