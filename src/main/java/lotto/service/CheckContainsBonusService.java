package lotto.service;

import static lotto.constants.ErrorMessage.LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class CheckContainsBonusService {

    public CheckContainsBonusService() {
    }

    public void validateWinningContainsBonus(Lotto winning, BonusNumber number) {
        if (winning.get().contains(number.get())) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED.get());
        }
    }
}
