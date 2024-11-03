package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
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

    // TODO: 추가 기능 구현
    int getWinningNumber(List<Integer> winnings, int bonus) {
        int count = (int) numbers.stream().filter(winnings::contains).count();

        if(count == 6 || (count == 5 && numbers.contains(bonus))) {
            return 7 - count;
        }

        return 7 - (count - 1);
    }


    void printNumber() {
        System.out.println("[" + numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
    }
}
