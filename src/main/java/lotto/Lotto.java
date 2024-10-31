package lotto;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = makeLotto(numbers);
    }

    private List<LottoNumber> makeLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNumber(number))
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateduplicate(numbers);
    }

    private void validateduplicate(List<Integer> numbers) {
        Long duplicateCount = numbers.stream()
                .distinct()
                .count();
        if (Long.compare(duplicateCount, numbers.size()) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 값이 있습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
