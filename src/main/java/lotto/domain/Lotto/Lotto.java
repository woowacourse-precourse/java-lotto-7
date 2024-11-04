package lotto.domain.Lotto;

import static lotto.domain.Lotto.LottoConstants.LOTTO_NUMBER_SIZE;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATED_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Number> lottoNumbers;

    protected Lotto(List<Number> numbers) {
        validateLotto(numbers);
        this.lottoNumbers = sortLottoNumber(numbers);
    }

    private List<Number> sortLottoNumber(List<Number> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getValue))
                .collect(Collectors.toList());
    }

    private void validateLotto(List<Number> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberSize(List<Number> numbers) {
        if (isValidNumberSize(numbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isValidNumberSize(List<Number> numbers) {
        return numbers.size() != LOTTO_NUMBER_SIZE;
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Number number : numbers) {
            if (hasDuplicatedNumber(uniqueNumbers, number)) {
                throw new IllegalArgumentException(INVALID_DUPLICATED_ERROR_MESSAGE);
            }
        }
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, Number number) {
        return !uniqueNumbers.add(number.getValue());
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
