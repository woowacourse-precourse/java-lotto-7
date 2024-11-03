package lotto.domain;

import java.util.*;

import static lotto.common.constants.LottoNumberType.*;
import static lotto.common.constants.exception.ErrorMessage.*;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Validator.validateLottoNumbers(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static class Validator {

        private static void validateLottoNumbers(List<Integer> numbers) {
            validateLottoNumberSize(numbers);
            validateUniqueLottoNumbers(numbers);
            validateLottoNumberRange(numbers);
        }

        private static void validateLottoNumberSize(List<Integer> numbers) {
            if (numbers.size() != LOTTO_SIZE.getNumber()) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
            }
        }

        private static void validateUniqueLottoNumbers(List<Integer> numbers) {
            int uniqueLottoNumbers = new HashSet<>(numbers).size();
            if (uniqueLottoNumbers != numbers.size()) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
            }
        }

        private static void validateLottoNumberRange(List<Integer> numbers) {
            boolean hasOutOfRangeNumber = numbers.stream()
                    .anyMatch(
                            lottoNumber -> lottoNumber < MINIMUM_LOTTO_NUMBER.getNumber()
                                    || lottoNumber > MAXIMUM_LOTTO_NUMBER.getNumber());

            if (hasOutOfRangeNumber) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }

    }

}