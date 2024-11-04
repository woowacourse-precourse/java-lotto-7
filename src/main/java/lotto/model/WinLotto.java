package lotto.model;

import java.util.List;
import lotto.utils.ErrorMessages;
import lotto.utils.LottoException;

public class WinLotto {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final Lotto winNumbers;
    private final int bonusNumber;

    public WinLotto(Lotto winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);

        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }


    public List<LottoRank> matchLottos(Lottos lottos) {
        return lottos.matchLottos(winNumbers, bonusNumber);
    }

    private void validate(Lotto winNumbers, int bonusNumber) {
        if (winNumbers.containsBonusNumber(bonusNumber)) {
            throw new LottoException(ErrorMessages.BONUS_NUMBER_DUPLICATED);
        }
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) {
            throw new LottoException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
