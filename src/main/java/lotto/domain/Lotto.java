package lotto.domain;

import java.util.List;
import lotto.global.common.Rank;

public class Lotto {

    public final static int TICKET_PRICE = 1_000;

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

    public Rank check(Lotto winningLotto, int bonus) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return Rank.valueOf(getMatchCount(numbers, winningNumbers), isBonusMatch(bonus));
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(int bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
