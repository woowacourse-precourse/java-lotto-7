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

    public LottoRank getMatchCount(Lotto winLotto, int bonusNumber) {
        int count = (int) numbers.stream()
                .filter(winLotto.getNumbers()::contains)
                .count();

        if(count == 6) {
            return LottoRank.FIRST;
        } else if(count == 5 && numbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        } else if(count == 5) {
            return LottoRank.THIRD;
        } else if(count == 4) {
            return LottoRank.FOURTH;
        } else if(count == 3) {
            return LottoRank.FIFTH;
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
