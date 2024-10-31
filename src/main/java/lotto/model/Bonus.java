package lotto.model;

import lotto.utils.ExceptionMessage;

public record Bonus(int bonus) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Bonus {
        validate(bonus);
    }

    private void validate(int bonus) {
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }
}
