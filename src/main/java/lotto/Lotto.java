package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정렬된 상태로 입력되어야 합니다.");
        }
        if (numbers.getFirst() < 1 || numbers.getLast() > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto generateLotto(List<Integer> numbers){
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        return new Lotto(sortedNumbers);
    }
}
