package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbers(numbers);
        validateEachNumber(numbers);
        validateDuplication(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("로또 번호는 NULL 일 수 없습니다.");
        }

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.");
        }
    }

    private void validateEachNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("로또 번호는 null 을 포함할 수 없습니다.");
            }

            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자입니다. 잘못된 숫자 : " + number);
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public boolean hasNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
