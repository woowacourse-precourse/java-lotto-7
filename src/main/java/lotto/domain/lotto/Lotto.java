package lotto.domain.lotto;

import static lotto.common.exception.ErrorMessage.LOTTO_CANNOT_BE_DUPLICATED;
import static lotto.common.exception.ErrorMessage.LOTTO_SIZE_MUST_BE_SIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.common.exception.LottoException;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplicate();
    }

    private void validateSize() {
        if (numbers.size() != 6) {
            throw new LottoException(LOTTO_SIZE_MUST_BE_SIX);
        }
    }

    private void validateDuplicate() {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new LottoException(LOTTO_CANNOT_BE_DUPLICATED);
        }
    }

    public List<LottoNumber> getLotto() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));

    }
}
