package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Validator.validator(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static class Validator {

        private static void validator(List<Integer> numbers) {
            validateLottoNumberSize(numbers);
            validateLottoNumberDuplicate(numbers);
        }

        private static void validateLottoNumberSize(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }

        private static void validateLottoNumberDuplicate(List<Integer> numbers) {
            Set<Integer> duplicateNumbers = new HashSet<>(numbers);
            if (duplicateNumbers.size() != numbers.size()) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }

    }

}