package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = toLottoNumbers(numbers);
        validateSize();
        validDuplicate(numbers);
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validDuplicate(List<Integer> inputNumbers) {
        if (inputNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되어서는 안됩니다.");
        }
    }

    private Set<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
    }

    // TODO: 추가 기능 구현
}
