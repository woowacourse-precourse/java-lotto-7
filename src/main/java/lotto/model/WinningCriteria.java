package lotto.model;

import java.util.Objects;

public class WinningCriteria {

    public static final String NULL_LOTTO_EXCEPTION_MESSAGE = "null인 lotto는 허용하지 않습니다.";
    public static final String NULL_BONUS_NUMBER_EXCEPTION_MESSAGE = "null인 bonusNumber는 허용하지 않습니다.";
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningCriteria(Lotto lotto, BonusNumber bonusNumber) {
        validateNull(lotto);
        validateNull(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateNull(Lotto lotto) {
        if (Objects.isNull(lotto)) {
            throw new IllegalArgumentException(NULL_LOTTO_EXCEPTION_MESSAGE);
        }
    }

    private void validateNull(BonusNumber bonusNumber) {
        if (Objects.isNull(bonusNumber)) {
            throw new IllegalArgumentException(NULL_BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
