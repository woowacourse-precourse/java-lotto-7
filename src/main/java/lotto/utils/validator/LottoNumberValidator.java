package lotto.utils.validator;

import static lotto.exception.ErrorMessages.OUT_OF_RANGE;

public class LottoNumberValidator implements Validator<Integer>{
    private final int LOWER_BOUND = 1;
    private final int UPPER_BOUND = 45;

    @Override
    public void validate(Integer value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }



}
