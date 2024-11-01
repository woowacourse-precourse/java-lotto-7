package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoValidator;

public class Lotto {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_SIZE = 6;
    public static final int PRICE = 1000;
    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LOTTO_VALIDATOR.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
