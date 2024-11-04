package lotto.model.domain;

import static lotto.config.LottoConfig.MAX_NUMBER;
import static lotto.config.LottoConfig.MIN_NUMBER;

import java.util.List;
import lotto.config.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public int validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        return bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}