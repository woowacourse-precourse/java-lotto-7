package lotto.domain;

import java.util.List;
import lotto.util.Converter;

public class WinningNumber {

    private final List<Integer> numbers;


    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public static WinningNumber from(String numbers) {
        return new WinningNumber(Converter.convertStringToIntegerList(numbers));
    }
}
