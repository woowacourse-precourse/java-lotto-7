package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted((a, b) -> a.value() - b.value())
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[Error] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(LottoNumber number) {
        return numbers.stream()
                .anyMatch(n -> n.value() == number.value());
    }
}
