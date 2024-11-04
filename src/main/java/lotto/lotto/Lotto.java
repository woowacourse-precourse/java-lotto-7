package lotto.lotto;

import java.util.List;
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
    }

    public Prize compare(WinningNumber winningNumber, int bonusNumber) {
        int count = (int) IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(winningNumber.getNumbers().get(i)))
                .count();
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return Prize.determinePrize(count, hasBonusNumber);
    }
}
