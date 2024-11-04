package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 당첨 번호와 일치하는 숫자 개수 카운트 메소드
    public int matchCount(Lotto winningNumber) {
        return (int) numbers.stream().filter(winningNumber.getNumbers()::contains).count();
    }
}
