package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public Lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNumbers() {
        System.out.printf("[%d, %d, %d, %d, %d, %d]\n",
                numbers.get(0), numbers.get(1), numbers.get(2),
                numbers.get(3), numbers.get(4), numbers.get(5));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) <= 0 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
            }
        }
        for (int i = 0; i < 5; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

}
