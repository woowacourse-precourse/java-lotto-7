package lotto.domain;

import static lotto.exception.LottoExceptionType.DUPLICATE_LOTTONUMBER;
import static lotto.exception.LottoExceptionType.NOT_MATCH_LOTTONUMBER;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(NOT_MATCH_LOTTONUMBER);
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != 6) {
            throw new LottoException(DUPLICATE_LOTTONUMBER);
        }
    }

    private List<LottoNumber> sorted(List<LottoNumber> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::lottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
