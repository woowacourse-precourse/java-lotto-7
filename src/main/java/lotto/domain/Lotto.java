package lotto.domain;

import lotto.exception.LottoArgumentException;
import lotto.exception.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (checkDuplicateNumbers(numbers)) {
            throw new LottoArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBERS_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private static boolean checkDuplicateNumbers(List<Integer> winNumbers) {
        Set<Integer> duplicateNumbers = new HashSet<>();
        return winNumbers.stream().anyMatch(number -> !duplicateNumbers.add(number));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }
}
