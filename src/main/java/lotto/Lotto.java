package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

        if (new HashSet<>(numbers).size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
    }

    int getWinningNumber(List<Integer> winnings, int bonus) {
        int count = (int) numbers.stream().filter(winnings::contains).count();

        if(count == 6 || (count == 5 && numbers.contains(bonus))) {
            return 7 - count;
        }

        return 7 - (count - 1);
    }

    String printNumber() {
        return "[" + numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}
