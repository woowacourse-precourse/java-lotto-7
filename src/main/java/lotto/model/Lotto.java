package lotto.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw LottoException.from(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX);
        }

        Set<Integer> seen = new HashSet<>();
        numbers.stream()
                .filter(number -> !seen.add(number))
                .findFirst()
                .ifPresent(duplicate -> {
                    throw LottoException.of(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE, duplicate);
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
