package lotto.domain;

import java.util.Arrays;
import java.util.List;
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

    // TODO: 추가 기능 구현
    // Lotto 하나 당 비용을 나타내는 메서드
    // toString 메서드 재정의
    public String toString() {
        String collected = Arrays.stream(numbers.toArray())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "[ " + collected + " ]";
    }
    // LottoWinningNumbers와 비교하는 메서드 (일치하는 숫자의 개수를 리턴)
}
