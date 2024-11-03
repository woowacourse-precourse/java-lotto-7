package lotto.lotto.domain;

import static lotto.common.rule.Rule.LOTTO_LENGTH;
import static lotto.common.rule.Rule.LOTTO_MAXIMUM_NUMBER;
import static lotto.common.rule.Rule.LOTTO_MINIMUM_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateIndividualNumber(Integer number, Set<Integer> numberSet) {
        if (LOTTO_MINIMUM_NUMBER > number || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 정수이어야 합니다.");
        }
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateIndividualNumber(number, numberSet);
        }
    }
}
