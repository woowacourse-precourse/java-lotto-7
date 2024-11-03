package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER_IS_NOT_ALLOWED;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> get() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumberSize(numbers);
        checkLottoNumberHasDuplicate(numbers);
    }

    private void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkLottoNumberHasDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IS_NOT_ALLOWED.getMessage());
        }
    }
}
