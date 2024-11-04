package lotto.lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {

    FIRST(new Money(2_000_000_000), 6, (correctCount, hasBonus) -> correctCount == 6),
    SECOND(new Money(30_000_000), 5, (correctCount, hasBonus) -> correctCount == 5 && hasBonus),
    THIRD(new Money(1_500_000), 5, (correctCount, hasBonus) -> correctCount == 5 && !hasBonus),
    FOURTH(new Money(50_000), 4, (correctCount, hasBonus) -> correctCount == 4),
    FIFTH(new Money(5_000), 3, (correctCount, hasBonus) -> correctCount == 3),
    NOTHING(new Money(0), 0, (correctCount, hasBonus) -> true);


    private final Money money;
    private final int count;
    private final BiPredicate<Integer, Boolean> condition;

    Prize(Money money, int count, BiPredicate<Integer, Boolean> condition) {
        this.money = money;
        this.count = count;
        this.condition = condition;
    }

    public static Prize determinePrize(int correctCount, boolean hasBonus) {

        return Arrays.stream(values())
                .filter(prize -> prize.condition.test(correctCount, hasBonus))
                .findFirst()
                .orElse(NOTHING);
    }

    public Money getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
