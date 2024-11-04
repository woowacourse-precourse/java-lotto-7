package lotto;

import java.util.List;
import lotto.exception.winning.LottoNumberDuplicatedException;
import lotto.exception.winning.LottoNumberOutOfRangeException;

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
        if (checkDuplicatedNumber(numbers)) {
            throw new LottoNumberDuplicatedException();
        }
        if (checkNumberRange(numbers)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean checkNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }

    private boolean checkDuplicatedNumber(List<Integer> numbers) {
        return distinctCount(numbers) != numbers.size();
    }

    private long distinctCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return List.copyOf(numbers);
    }
}
