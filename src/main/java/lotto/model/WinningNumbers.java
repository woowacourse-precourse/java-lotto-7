package lotto.model;

import static lotto.constant.ExceptionMessage.DUPLICATE_BONUS_BALL;
import static lotto.constant.ExceptionMessage.INVALID_BONUS_BALL_RANGE;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

public record WinningNumbers(Lotto lotto, int bonusBall) {
    public WinningNumbers {
        validate(lotto, bonusBall);
    }

    private void validate(Lotto lotto, int bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_BALL.getMessage());
        }
        if (bonusBall < MIN_NUMBER.getValue() || bonusBall > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_BONUS_BALL_RANGE.getMessage());
        }
    }
}
