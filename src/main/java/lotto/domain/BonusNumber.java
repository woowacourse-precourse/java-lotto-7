package lotto.domain;

import java.util.Objects;

import static lotto.exception.ErrorMessages.INPUT_EMPTY_ERROR;
import static lotto.exception.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_ERROR;
import static lotto.util.Validator.isEmpty;
import static lotto.util.Validator.isInteger;

public class BonusNumber {
    private int value;

    public BonusNumber(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value){
        if(isEmpty(value)){
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR);
        }

        if(!isInteger(value) || !isInRange1To45(value)){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private boolean isInRange1To45(String value){
        int number = Integer.parseInt(value);
        return number > 0 && number < 46;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
