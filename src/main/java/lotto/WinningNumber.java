package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 맞지 않습니다.");
        }
    }


}
