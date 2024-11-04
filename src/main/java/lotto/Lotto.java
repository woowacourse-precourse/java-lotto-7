package lotto;

import java.util.List;

import static lotto.constants.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
        if (numbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
