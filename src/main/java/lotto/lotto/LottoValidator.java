package lotto.lotto;

import java.util.List;
import lotto.io.output.ErrorMessage;
import lotto.random.Random;

public class LottoValidator {

    private LottoValidator() {

    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < Random.START_INCLUSIVE || number > Random.END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
