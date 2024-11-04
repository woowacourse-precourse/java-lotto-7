package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }
}