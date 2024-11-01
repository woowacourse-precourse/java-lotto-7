package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int NUMBER_SIZE = 6;
    public static final int PRICE = 1000;
    public static final int LOTTO_SIZE = 6;

    public static final String SIZE_ERROR_MESSAGE = "로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";
    public static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "로또 번호는 중복되지 않은 6개의 숫자여야 합니다.";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
}
