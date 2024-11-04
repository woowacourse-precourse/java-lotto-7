package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = Set.copyOf(numbers);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
