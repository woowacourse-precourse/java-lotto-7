package lotto.Model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println(Constants.LOTTO_NUMS_DUPLICATE_ERROR);
            throw new IllegalArgumentException(Constants.LOTTO_NUMS_DUPLICATE_ERROR);
        }
    }

    public void printLotto() {
        System.out.print("[");
        System.out.print(numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println("]");
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
