package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 6개 숫자여야 합니다.");
        }
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public int matchCount(LottoTicket winningTicket) {
        return (int) winningTicket.numbers.stream().filter(numbers :: contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
