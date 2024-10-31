package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoConstant;

public class Lotto {

    private static final String LOTTO_MESSAGE_PREFIX = "[";
    private static final String LOTTO_MESSAGE_SUFFIX = "]";
    private static final String COMMA = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberOfLottoNumbers(numbers);
        validateLottoNumberRange(numbers);
        validateLottoDuplicated(numbers);
    }

    private void validateNumberOfLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_OF_LOTTO_NUMBERS.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber() || number > LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호가 1~45 범위를 벗어납니다.");
            }
        }
    }

    private void validateLottoDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < LottoConstant.NUMBER_OF_LOTTO_NUMBERS.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return LOTTO_MESSAGE_PREFIX + String.join(COMMA, sortedNumbers
                .stream()
                .map(Object::toString)
                .toList()) + LOTTO_MESSAGE_SUFFIX;
    }
}
