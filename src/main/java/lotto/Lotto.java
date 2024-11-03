package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
