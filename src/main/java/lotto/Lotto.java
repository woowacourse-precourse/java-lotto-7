package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자를 입력할 수 없습니다.");
            }
            winningNumbers.add(number);
        }
    }
    public int countCollect(List<Integer> winningNumbers) {
        int collect = 0;
        for (Integer number : getNumbers()) {
            if (winningNumbers.contains(number)) {
                collect++;
            }
        }
        return collect;
    }
    public boolean checkBonus(List<Integer> numbers, int bonus) {
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(bonus)) return true;
        }
        return false;
    }
    // TODO: 추가 기능 구현
}
