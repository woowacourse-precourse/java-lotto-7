package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        this.numbers = numbers;
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
    }

}
