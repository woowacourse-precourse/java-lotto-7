package lotto.domain;

import lotto.constant.NumberConstant;

import java.util.Collections;
import java.util.List;

import static lotto.constant.NumberConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validatePositiveNumber(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LOTTO_NUMBER_RANGE_START > number || LOTTO_NUMBER_RANGE_END < number) {
                throw new IllegalArgumentException("로또 범위내로 입력해주세요.");
            }
        }
    }

    private void validatePositiveNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수가 아닙니다.");
            }
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        long result = numbers.stream()
                .distinct()
                .count();

        if (result != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }
}
