package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final List<Integer> numbers;

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public static WinningLotto from(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }

    public int getMatchedNumberCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContain)
                .count();
    }
}