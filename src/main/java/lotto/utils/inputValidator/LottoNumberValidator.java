package lotto.utils.inputValidator;

import static lotto.exception.ErrorMessages.OUT_OF_RANGE;
import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.UPPER_BOUND;

public class LottoNumberValidator implements InputValidator<Integer> {

    @Override
    public void validate(Integer number) {
        if (number < LOWER_BOUND.getValue() || number > UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE.getMessage(), LOWER_BOUND.getValue(),UPPER_BOUND.getValue()));
        }
    }



}
