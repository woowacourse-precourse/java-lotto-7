package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.model.enums.LottoConstants;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if ( bonusNumber > LottoConstants.LOTTO_END_NUMBER.getValue() ||
                bonusNumber < LottoConstants.LOTTO_BEGIN_NUMBER.getValue() ) {
            throw new IllegalArgumentException(ErrorMessage.WITHIN_NUMBERS_RANGE.getMessage());
        }
        for ( int number : this.getNumbers() ) {
            if ( bonusNumber == number ) {
                throw new IllegalArgumentException(ErrorMessage.CANNOT_DUPLICATE.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
