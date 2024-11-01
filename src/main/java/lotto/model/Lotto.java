package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (countUniqueNumbers(numbers) != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private long countUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
