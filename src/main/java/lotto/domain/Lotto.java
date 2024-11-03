package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.exception.constants.ErrorMessage.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.constants.ErrorMessage.LOTTO_NUMBER_SIZE_NOT_MATCH;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);

        this.numbers = convertToLottoNumbers(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getValue()) {
            throw new LottoException(LOTTO_NUMBER_SIZE_NOT_MATCH.getMessage());
        }
    }

    private void validateDuplicatedNumber(final List<Integer> numbers) {
        if (isDuplicatedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    private boolean isDuplicatedNumber(final List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .toList();
    }
}
