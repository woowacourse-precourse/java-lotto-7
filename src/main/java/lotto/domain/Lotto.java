package lotto.domain;

import java.util.*;

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
        return numbers;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private static class Validator {

        private static void validateLottoNumbers(List<Integer> numbers) {
            validateLottoNumberSize(numbers);
            validateLottoNumberDuplicate(numbers);
            validateLottoNumberRange(numbers);
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

        private static void validateLottoNumberRange(List<Integer> numbers) {
            boolean hasOutOfRangeNumber = numbers.stream()
                    .anyMatch(lottoNumber -> lottoNumber < 1 || lottoNumber > 45);

            if (hasOutOfRangeNumber) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
            }
        }

    }

}