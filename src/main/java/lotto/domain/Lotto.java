package lotto.domain;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoConstants.NUMBER_OF_LOTTO + "개여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < LottoConstants.RANDOM_LOWER_BOUND || number > LottoConstants.RANDOM_UPPER_BOUND) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                        + LottoConstants.RANDOM_LOWER_BOUND + "부터 " + LottoConstants.RANDOM_UPPER_BOUND + " 사이의 숫자여야 합니다.");
            }
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
