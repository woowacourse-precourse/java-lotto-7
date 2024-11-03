package lotto.domain;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoErrorMessage.DUPLICATE_INPUT_NUMBER;
import static lotto.constants.LottoErrorMessage.NUMBER_OUT_OF_RANGE;

public class JackpotNumbers {

    private Lotto lotto;
    private int bonusNumber;

    public JackpotNumbers() {
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        validateInRange(bonusNumber);
        validateDuplicates(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateInRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicates(int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.getMessage());
        }
    }
}