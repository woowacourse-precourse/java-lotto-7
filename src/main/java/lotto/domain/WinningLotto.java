package lotto.domain;

import static lotto.service.exception.LottoExceptionMessage.BONUS_NUMBER_DUPLICATED;

import java.util.List;
import lotto.service.exception.LottoException;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.lotto = Lotto.from(winningNumbers);
        this.bonusNumber = BonusNumber.from(bonusNumber);
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(BONUS_NUMBER_DUPLICATED);
        }
    }
}
