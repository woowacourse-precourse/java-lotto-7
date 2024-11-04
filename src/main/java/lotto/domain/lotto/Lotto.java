package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Lotto {
    private final List<Number> numbers;

    protected Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        this.numbers = convert(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Number> convert(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::of)
                .sorted()
                .toList();
    }

    public boolean contains(Number target) {
        return numbers.stream()
                .anyMatch(number -> number.equals(target));
    }

    public int countMatchingNumbers(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static class Validator {
        private static void validate(List<Integer> numbers) {
            validateSize(numbers, LottoDetail.NUMBER_COUNT);
            validateDuplicate(numbers);
        }

        private static void validateSize(List<Integer> numbers,
                                         LottoDetail threshold) {
            if (isNotCorrectSize(numbers, threshold)) {
                throw new LottoException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE);
            }
        }

        private static boolean isNotCorrectSize(List<Integer> numbers,
                                                LottoDetail threshold) {
            return numbers.size() != threshold.getValue();
        }

        private static void validateDuplicate(List<Integer> numbers) {
            if (isDuplicatedIn(numbers)) {
                throw new LottoException(ErrorMessage.INVALID_DUPLICATION_NUMBER);
            }
        }

        private static boolean isDuplicatedIn(List<Integer> numbers) {
            return numbers.size() != getUniqueCount(numbers);
        }

        private static int getUniqueCount(List<Integer> numbers) {
            return numbers.stream()
                    .distinct()
                    .toList()
                    .size();
        }
    }
}
