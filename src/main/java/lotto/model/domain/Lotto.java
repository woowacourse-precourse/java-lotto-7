package lotto.model.domain;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoCountShouldBeSixValidator(numbers);
        lottoNumberRangeValidator(numbers);
        lottoDuplicateValidator(numbers);
        this.numbers = numbers;
    }

    private void lottoCountShouldBeSixValidator(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void lottoNumberRangeValidator(List<Integer> numbers) {
        for (int number : numbers) {
            if (number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    private void lottoDuplicateValidator(List<Integer> numbers) {
        Set<Integer> lottoNumbersSet = Set.copyOf(numbers);
        if (lottoNumbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}