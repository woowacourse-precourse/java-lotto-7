package lotto.lottoMachine;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoDuplicateException;
import lotto.exception.LottoInvalidSizeException;
import lotto.exception.LottoOutOfBoundException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoInvalidSizeException();
        }

        if(numbers.stream().anyMatch(num -> num > 45 || num < 1)) {
            throw new LottoOutOfBoundException();
        }

        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new LottoDuplicateException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
