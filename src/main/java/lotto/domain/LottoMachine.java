package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE;

import java.util.List;
import lotto.exception.LottoException;

public class LottoMachine {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private LottoMachine(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoMachine of(List<Integer> numbers, int bonus) {
        validateBonusNumberDuplicate(numbers, bonus);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = BonusNumber.from(bonus);
        return new LottoMachine(lotto, bonusNumber);
    }

    private static void validateBonusNumberDuplicate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new LottoException(INVALID_BONUS_NUMBER_DUPLICATE);
        }
    }
}
