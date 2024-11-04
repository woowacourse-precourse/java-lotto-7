package lotto.lotto.value;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        validateDuplicate(numbers);
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Prize compare(WinningNumber winningNumber, int bonusNumber) {
        int count = (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.contains(winningNumber.getNumbers().get(i)))
                .count();
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return Prize.determinePrize(count, hasBonusNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
