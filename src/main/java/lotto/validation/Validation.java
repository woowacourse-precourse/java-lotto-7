package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.validation.ErrorMessage.*;

public class Validation {

    public void checkLottoSize(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException(LOTTO_ERROR_WRONG_LOTTO_SIZE.getMessage());
        }
    }

}
