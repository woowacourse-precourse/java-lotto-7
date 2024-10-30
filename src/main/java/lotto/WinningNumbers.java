package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers = new ArrayList<>();

    public WinningNumbers(List<String> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            this.numbers.add(Integer.parseInt(numbers.get(i)));
        }
    }
}
