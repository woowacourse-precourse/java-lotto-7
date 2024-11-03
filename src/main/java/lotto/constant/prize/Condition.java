package lotto.constant.prize;

import java.util.function.BiPredicate;

class Condition {
    public static final BiPredicate<Integer, Boolean> FIFTH_PRIZE = (matchedCount, hasBonus) -> matchedCount == 3;
    public static final BiPredicate<Integer, Boolean> FOURTH_PRIZE = (matchedCount, hasBonus) -> matchedCount == 4;
    public static final BiPredicate<Integer, Boolean> THIRD_PRIZE = (matchedCount, hasBonus) -> matchedCount == 5 && !hasBonus;
    public static final BiPredicate<Integer, Boolean> SECOND_PRIZE = (matchedCount, hasBonus) -> matchedCount == 5 && hasBonus;
    public static final BiPredicate<Integer, Boolean> FIRST_PRIZE = (matchedCount, hasBonus) -> matchedCount == 6;
    public static final BiPredicate<Integer, Boolean> NON_PRIZE = (matchedCount, hasBonus) -> true;

    private Condition() {
    }
}
