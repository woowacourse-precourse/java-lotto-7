package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static List<Integer> numbers = new ArrayList<>();

    public WinningNumber(String numbers) {
        setWinningNumber(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    private void setWinningNumber(String input) {

        String[] numbers = input.split(",");
        for (String number : numbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

}
