package lotto.domain;

import java.util.List;
import lotto.generator.LottoGenerator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomNumberLotto(LottoGenerator lottoGenerator) {
        List<Integer> generatedSortedNumbers = lottoGenerator.generate().stream()
                .sorted().toList();
        return new Lotto(generatedSortedNumbers);
    }

    public static Lotto createFixedNumberLotto(List<Integer> numbers) {
        List<Integer> sortedNumber = numbers.stream().sorted().toList();
        return new Lotto(sortedNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
