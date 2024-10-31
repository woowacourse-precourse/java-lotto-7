package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.dto.LottoDTO;
import lotto.common.ExceptionCode;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoDTO toLottoDTO() {
        return new LottoDTO(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        isUniqueNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_LOTTO_SIZE.message());
        }
    }

    private void isUniqueNumbers(List<Integer> numbers) {
        HashSet<Integer> unique = new HashSet<>(numbers);
        if (numbers.size() != unique.size()) {
            throw new IllegalArgumentException(ExceptionCode.LOTTO_DOES_NOT_UNIQUE.message());
        }
    }
}
