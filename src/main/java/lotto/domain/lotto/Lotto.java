package lotto.domain.lotto;

import static lotto.constant.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConfig.DEFAULT_NUMBER_COUNT;

import java.util.List;
import java.util.Set;

import lotto.random.LottoRandom;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .map(Number::new)
            .toList();
    }

    public Lotto(LottoRandom lottoRandom) {
        this(lottoRandom.getLottoNumbers());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        Set<Integer> filteredNumbers = Set.copyOf(numbers);
        if (filteredNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
            .map(Number::get)
            .toList();
    }

    public boolean contains(int number) {
        return numbers.contains(new Number(number));
    }
}
