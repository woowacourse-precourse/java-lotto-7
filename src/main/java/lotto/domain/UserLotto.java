package lotto.domain;

import static lotto.constants.Constants.LOTTO_MAX;
import static lotto.constants.Constants.LOTTO_MIN;
import static lotto.utils.NumberValidator.validateNumberRange;

import lotto.constants.ErrorMessages;

public class UserLotto {
    private final int bonusBall;
    private final Lotto userLotto;

    private UserLotto(Lotto userLotto, int bonusBall) {
        validate(userLotto, bonusBall);
        this.userLotto = userLotto;
        this.bonusBall = bonusBall;
    }

    public static UserLotto of(Lotto userLotto, int bonusBall) {
        return new UserLotto(userLotto, bonusBall);
    }

    public Lotto getUserLotto() {
        return userLotto;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    private void validate(Lotto lotto, int number) {
        validateDuplication(lotto, number);
        validateNumberRange(number, LOTTO_MIN, LOTTO_MAX);
    }

    private void validateDuplication(Lotto lotto, int number) {
        if (isDuplicated(lotto, number)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(Lotto lotto, int number) {
        return lotto.hasNumber(number);
    }
}
