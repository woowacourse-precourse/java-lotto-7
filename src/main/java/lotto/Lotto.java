package lotto;

import java.util.ArrayList;
import java.util.List;
import message.ErrorMessage;

public class Lotto {

    static final int PRICE = 1000;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;
    static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidNumberRange(numbers);
        isDuplicate(numbers);
        isValidNumberSize(numbers);
    }

    private void isValidNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        for (Integer Number : numbers) {
            if (duplicateNumbers.contains(Number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
            duplicateNumbers.add(Number);
        }
    }

    private void isValidNumberRange(List<Integer> numbers) {
        for (Integer Number : numbers) {
            if ((Number < MIN_NUM) || (Number > MAX_NUM)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public boolean haveNumber(int number) {
        return numbers.contains(number);
    }

    protected List<Integer> getLottoNumber() {
        return numbers;
    }
}
