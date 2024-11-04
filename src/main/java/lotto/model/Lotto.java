package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validateLotto(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();
        lottoValidator.validateLotto(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }

    public long matchingCountWith(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
