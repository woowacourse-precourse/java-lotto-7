package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public Optional<LottoResult> getResult(LottoAnswer answer) {
        long match = numbers.stream()
                .filter(answer::isNumberMatch)
                .count();
        boolean bonusMatch = numbers.stream()
                .anyMatch(answer::isBonusMatch);
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.isMatch((int) match, bonusMatch))
                .findFirst();
    }
}
