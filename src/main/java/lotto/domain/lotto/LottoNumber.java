package lotto.domain.lotto;

import static lotto.exception.message.LottoExceptionMessage.INVALID_NUMBER_RANGE;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<LottoNumber> CACHE = new ArrayList<>();

    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHE.add(new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateNumberRange(number);
        return CACHE.get(number - 1);
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(INVALID_NUMBER_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

}