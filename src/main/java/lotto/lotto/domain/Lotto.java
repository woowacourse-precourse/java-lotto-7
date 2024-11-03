package lotto.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Set<Integer> numberSet = new HashSet<>();
        for(Integer number : numbers) {
            validateIndividualNumber(number, numberSet);
        }
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateIndividualNumber(Integer number, Set<Integer> numberSet) {
        if (0 > number || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 정수이어야 합니다.");
        }
        if(!numberSet.add(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
