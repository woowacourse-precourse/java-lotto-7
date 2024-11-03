package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        ValidationUtil.validateLottoNumbers(Set.copyOf(numbers));
        this.numbers = List.copyOf(numbers);
    }

    public List<Integer> getSortednumbers() {
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    public int matchCount(LottoTicket winningTicket) {
        return (int) winningTicket.numbers.stream().filter(numbers::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
