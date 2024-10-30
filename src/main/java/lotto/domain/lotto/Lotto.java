package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;
import lotto.infrastructure.exception.CustomException;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(LottoNumber::of)
                .toList();
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> removedDuplicate = new HashSet<>(numbers);
        if (removedDuplicate.size() != numbers.size()) {
            throw new CustomException("로또 번호는 서로 중복될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        List<String> numberStrings = numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", numberStrings) + "]";
    }
}
