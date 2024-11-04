package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}