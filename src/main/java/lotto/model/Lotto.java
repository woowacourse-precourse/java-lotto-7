package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 %d개여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";


    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);

        validateNumberRange(numbers);

        validateNumberDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_COUNT_ERROR, LOTTO_NUMBER_COUNT));
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            if (!numberSet.contains(number)) {
                numberSet.add(number);
            }
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::isInRange);
    }

    private void isInRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_NUMBER_RANGE_ERROR, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }


}
