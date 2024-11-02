package lotto.domain.cost;

import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.exception.CustomException;

public record Cost(int value) {
    public static final int UNIT = 1000;
    public static final int LOTTO = 1000;
    public static final int MAX = 50_000;

    public static Cost of(int cost) {
        validateCostRange(cost);
        validateCostUnit(cost);
        return new Cost(cost);
    }

    public int getPurchaseCount() {
        return value / LOTTO;
    }

    private static void validateCostRange(int cost) {
        if (cost <= 0) {
            throw new CustomException(ExceptionMessage.PURCHASE_LESS_THAN_ONE);
        }
        if (cost > MAX) {
            throw new CustomException(ExceptionMessage.PURCHASE_MORE_THAN_MAX);
        }
    }

    private static void validateCostUnit(int cost) {
        if (cost % UNIT != 0) {
            throw new CustomException(ExceptionMessage.INVALID_PURCHASE_UNIT);
        }
    }
}
