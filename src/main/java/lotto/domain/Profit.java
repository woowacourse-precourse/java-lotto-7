package lotto.domain;

import java.util.function.Function;
import lotto.constant.Constant;

public enum Profit {
    THREE_MATCHES(count -> count * Constant.THREE_MATCHES_PROFIT),
    FOUR_MATCHES(count -> count * Constant.FOUR_MATCHES_PROFIT),
    FIVE_MATCHES(count -> count * Constant.FIVE_MATCHES_PROFIT),
    FIVE_MATCHES_BONUS_MATCH(count -> count * Constant.FIVE_MATCHES_BONUS_MATCH_PROFIT),
    SIX_MATCHES(count -> count * Constant.SIX_MATCHES_PROFIT);

    private Function<Integer, Integer> expression;

    Profit(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public int calculate(int count) {
        return expression.apply(count);
    }
}
