package lotto.domain;

import lotto.error.Error;
import lotto.error.ThrowException;

public class WinningLotto {

    private final Lotto firstPlaceLotto;
    private final BonusLotto bonusLotto;

    public WinningLotto(Lotto firstPlaceLotto, BonusLotto bonusLotto) {
        validate(firstPlaceLotto, bonusLotto);
        this.firstPlaceLotto = firstPlaceLotto;
        this.bonusLotto = bonusLotto;
    }

    private void validate(Lotto firstPlaceLotto, BonusLotto bonusLotto) {
        boolean validateDuplicate = firstPlaceLotto.contains(bonusLotto.getBonusNumber());
        String errorFormat = Error.DUPLICATE_LOTTO_NUMBER.getMessage();
        ThrowException.throwIllegalArgumentException(validateDuplicate, errorFormat);
    }

    public Lotto getFirstPlaceLotto() {
        return firstPlaceLotto;
    }

    public BonusLotto getBonusLotto() {
        return bonusLotto;
    }
}
