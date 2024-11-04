package lotto.domain;

import java.util.function.Function;

public enum Prize {
    MATCHES_3(count -> count * 5000),
    MATCHES_4(count -> count * 50000),
    MATCHES_5(count -> count * 1500000),
    MATCHES_5_BONUS_MATCH(count -> count * 30000000),
    MATCHES_6(count -> count * 2000000000);

    private Function<Integer, Integer> expression;

    Prize(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public int calculate(int count) {
        return expression.apply(count);
    }
}
