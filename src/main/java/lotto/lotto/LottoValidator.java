package lotto.lotto;

import java.util.List;

public class LottoValidator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    private LottoValidator() {

    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberInRange(number);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException("Number must be between 1 and 45");
        }
    }
}
