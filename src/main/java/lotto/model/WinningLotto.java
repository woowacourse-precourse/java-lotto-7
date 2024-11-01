package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if ( bonusNumber > 45 || bonusNumber < 1 ) {
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
