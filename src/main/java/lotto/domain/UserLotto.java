package lotto.domain;

import lotto.constants.ErrorMessages;

public class UserLotto {
    private final int bonusBall;
    private final Lotto userLotto;

    public UserLotto(Lotto userLotto, int bonusBall) {
        validate(userLotto, bonusBall);
        this.userLotto = userLotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto lotto, int number) {
        validateDuplication(lotto, number);
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
