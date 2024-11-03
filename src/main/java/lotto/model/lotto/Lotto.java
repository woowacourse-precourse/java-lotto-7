package lotto.model.lotto;

import static java.util.Objects.isNull;
import static lotto.exception.DuplicatedNumberException.duplicatedLottoNumber;
import static lotto.exception.ShouldNotBeNullException.nullArgument;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MAX_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        validateMaxLength(numbers);
        validateDuplicatedNumber(numbers);
        return new Lotto(numbers);
    }

    public int countMatchedNumbersFrom(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::has)
                .count();
    }

    public boolean has(final Integer number) {
        validateIsNull(number);
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        List<String> strNumbers = numbers.stream()
                .map(String::valueOf)
                .toList();
        return String.join(", ", strNumbers);
    }

    public void validateIsNull(final Integer source) {
        if (isNull(source)) {
            throw nullArgument();
        }
    }

    private static void validateMaxLength(final List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicatedNumber(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw duplicatedLottoNumber();
        }
    }
}
