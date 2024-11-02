package lotto.domain;

import java.util.List;
import lotto.util.Converter;

public class WinningNumber {

    private final List<Integer> numbers;


    public WinningNumber(String numbers) {
        this.numbers = Converter.convertStringToIntegerList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
