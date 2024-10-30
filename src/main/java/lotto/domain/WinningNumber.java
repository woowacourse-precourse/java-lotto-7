package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public WinningNumber(String numbers, String bonusNumber) {
        setWinningNumber(numbers);

        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setWinningNumber(String input) {

        String[] numbers = input.split(",");
        for (String number : numbers) {
            this.numbers.add(Integer.parseInt(number));
        }
    }

}
