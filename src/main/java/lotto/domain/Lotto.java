package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) { // 중복을 제거한 stream의 사이즈와 원본과 다르다면
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
