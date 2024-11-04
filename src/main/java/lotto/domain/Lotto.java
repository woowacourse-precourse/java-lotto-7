package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumber(numbers);
        validateUniqueLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45인 정수여야 합니다.");
            }
        }
    }

    private void validateUniqueLottoNumber(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 중복되지 않은 수여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
