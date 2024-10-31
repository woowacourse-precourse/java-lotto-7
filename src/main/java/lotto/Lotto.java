package lotto;

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

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public void print() {
        System.out.print("[");
        System.out.print(getJoinedNumbers());
        System.out.println("]");
    }

    private String getJoinedNumbers() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public long getMatchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // TODO: 추가 기능 구현
}
