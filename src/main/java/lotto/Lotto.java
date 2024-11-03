package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        ValidationUtil.validateLottoNumbers(Set.copyOf(numbers));
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int matchCount(Lotto winningTicket) {
        return (int) winningTicket.numbers.stream().filter(numbers::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
