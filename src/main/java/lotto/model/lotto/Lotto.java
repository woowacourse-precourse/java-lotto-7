package lotto.model.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.draw.BonusNumber;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicationNumber(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if ( number < 1 || number > 45 ) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int countSameNumber(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if(lotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream().sorted().map(Object::toString).collect(Collectors.joining(", "))
                + "]";
    }
}
