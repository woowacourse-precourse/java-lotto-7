package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.Number;

public class Lotto {
    private final List<Number> numbers;

    private Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        this.numbers = generate(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Number> generate(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::of)
                .sorted()
                .toList();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private static class Validator {
        private static void validate(List<Integer> numbers) {
            validateSize(numbers);
            validateDuplicate(numbers);
        }

        private static void validateSize(List<Integer> numbers) {
            if (isNotCorrectSize(numbers)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }

        private static boolean isNotCorrectSize(List<Integer> numbers) {
            return numbers.size() != 6;
        }

        private static void validateDuplicate(List<Integer> numbers) {
            if (isDuplicatedIn(numbers)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
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
