package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_DEFAULT_COUNT;
import static lotto.exception.ErrorMessage.*;

import java.util.List;
import java.util.Objects;
import lotto.domain.vo.LottoNumber;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = sortNumbers(numbers);
        return new Lotto(
                sortedNumbers.stream()
                        .map(LottoNumber::of)
                        .toList()
        );
    }

    private static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateDuplicateLottoNumbers(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DEFAULT_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static void validateDuplicateLottoNumbers(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted().toList();
    }

    public List<Integer> getNumbersAsUnmodifiableList() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .toList(); // unmodifiableList 반환
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> Objects.equals(
                        number.getValue(),
                        lottoNumber.getValue())
                );
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) this.numbers
                .stream()
                .filter(otherLotto::contains)
                .count();
    }
}
