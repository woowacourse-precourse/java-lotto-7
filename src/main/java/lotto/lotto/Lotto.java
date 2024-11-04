package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;

public record Lotto(List<LottoNumber> numbers) {
    public static final int LOTTO_SIZE = 6;

    public Lotto {
        validate(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void validate(List<LottoNumber> numbers) {
        if (isSizeInvalid(numbers)) {
            throw LottoException.INVALID_NUMBER_SIZE.getException();
        }

        if (hasDuplicatedNumber(numbers)) {
            throw LottoException.DUPLICATED_NUMBER.getException();
        }
    }

    private boolean isSizeInvalid(List<LottoNumber> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplicatedNumber(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }
}
