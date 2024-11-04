package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.utils.ConstantMessage.ErrorMessage;
import lotto.utils.ConstantValue;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        } else if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_VALUE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    static public Lotto pickLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                ConstantValue.LOTTO_MIN_VALUE,
                ConstantValue.LOTTO_MAX_VALUE,
                ConstantValue.LOTTO_NUMBER_COUNT
        );
        return new Lotto(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(List<Integer> winningNumber) {
        return (int) this.numbers.stream().filter(winningNumber::contains).count();
    }

    public boolean hasBonus(int isBonus) {
        return this.numbers.contains(isBonus);
    }
}
