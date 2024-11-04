package lotto.model;

import java.util.Iterator;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers from(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    public Iterator<Integer> getNumbers() {
        return numbers.iterator();
    }
}
