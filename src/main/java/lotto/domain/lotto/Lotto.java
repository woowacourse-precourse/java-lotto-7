package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplicate();
    }

    private void validateSize() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate() {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLotto() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));

    }
}
