package lotto.lottoMachine;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.exception.LottoDuplicateException;
import lotto.exception.LottoInvalidException;
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

    public LottoResult getMatchCount(Lotto winLotto, int bonusNumber) {
        List<Integer> winNumbers = winLotto.getNumbers();
        int size = numbers.stream().filter(o -> winNumbers.stream()
                .anyMatch(Predicate.isEqual(o))).toList()
                .size();

        if(size == 6) {
            return LottoResult.FIRST;
        } else if(size == 5 && numbers.contains(bonusNumber)) {
            return LottoResult.SECOND;
        } else if(size == 5) {
            return LottoResult.THIRD;
        } else if(size == 4) {
            return LottoResult.FOURTH;
        } else if(size == 3) {
            return LottoResult.FIFTH;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String join = numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", "));
        sb.append("[").append(join).append("]");

        return sb.toString();
    }
}
