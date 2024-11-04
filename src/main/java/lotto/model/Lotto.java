package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            checkLottoNum(number);
        }
    }

    private void checkLottoNum(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
