package lotto.domain;

import static lotto.global.Error.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.global.Error.LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46;

import java.util.List;

public class LottoBonus {

    private int bonusNumber;

    public LottoBonus(int bonusNumber, List<Integer> winningLottoNumbers) {
        validate(bonusNumber, winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winningLottoNumbers) {
        validateNumbersDuplicated(bonusNumber, winningLottoNumbers);
        validateNumberNotBetween1And46(bonusNumber);
    }

    private void validateNumbersDuplicated(int bonusNumber, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED.getErrorMsg());
        }
    }

    private void validateNumberNotBetween1And46(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 46) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46.getErrorMsg());
        }
    }
}
