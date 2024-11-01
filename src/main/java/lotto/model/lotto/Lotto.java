package lotto.model.lotto;

import java.util.List;
import java.util.Objects;
import lotto.model.lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = List.copyOf(numbers.stream().sorted().toList());
    }


    public int getMatchCount(Lotto winnerNumbers) {
        return (int) numbers.stream()
                .filter(winnerNumbers.getNumbers()::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto lotto)) return false;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
