package lotto.domain.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Length;
import lotto.config.validation.annotation.Unique;

public class Lotto extends FieldValidation {

    public static final int PRICE = 1_000;

    @Unique
    @Length(min = 6, max = 6)
    private final List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this.numbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        super.valid();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int match(LottoNumber targetNumber) {
        if (numbers.stream().anyMatch(targetNumber::equals)) {
            return 1;
        }

        return 0;
    }

    public int match(List<LottoNumber> targetNumbers) {
        return (int) numbers.stream()
                .filter(targetNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        String numbers = this.numbers.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "[" + numbers + "]";
    }
}
