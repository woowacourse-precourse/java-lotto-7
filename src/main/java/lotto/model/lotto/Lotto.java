package lotto.model.lotto;

import java.util.List;

public class Lotto {

    private static final int MAX_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        List<String> strNumbers = numbers.stream()
                .map(String::valueOf)
                .toList();
        return String.join(", ", strNumbers);
    }
}
