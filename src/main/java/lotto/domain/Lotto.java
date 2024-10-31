package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicates = new HashSet<>(numbers);
        if (noDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    public boolean has(LottoNumber number) {
        return numbers.contains(number);
    }
}
