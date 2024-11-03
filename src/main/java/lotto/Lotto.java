package lotto;

import lotto.enums.Value;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Value.lottoNumberCount) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < Value.lottoStartNumber || number > Value.lottoEndNumber) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
            }
        }
        if (numbers.stream().distinct().count() != Value.lottoNumberCount) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }
}
