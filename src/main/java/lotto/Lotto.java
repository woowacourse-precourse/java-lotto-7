package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != getDistinctSize(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static int getDistinctSize(List<Integer> numbers) {
        return numbers.stream().distinct().toList().size();
    }

    // TODO: 추가 기능 구현

}
