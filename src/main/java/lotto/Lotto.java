package lotto;

import static lotto.eunm.LottoConstants.*;
import static lotto.vaildate.ErrorMessage.INVALID_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.vaildate.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT.value) {
            throw new IllegalArgumentException(ErrorMessage.UNIQUE_NUMBER);
        }
    }

    public List<Integer> getSortNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers;
    }

    public static Lotto createNumber() {
        return new Lotto(createRandomNumber());
    }

    private static List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER.value, MAX_LOTTO_NUMBER.value,
                LOTTO_NUMBERS_COUNT.value);
    }

}
