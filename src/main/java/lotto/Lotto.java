package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        validate(sortedNumbers, 1, 45, 6);
        this.numbers = sortedNumbers;
    }

    public Lotto(int startNumber, int endNumber, int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNumbers(int count) {
        System.out.print("[");
        for (int i = 0; i < count - 1; i++) {
            System.out.printf("%d, ", numbers.get(i));
        }
        System.out.printf("%d]\n", numbers.get(count - 1));
    }

    private void validate(List<Integer> numbers, int startNumber, int endNumber, int count) {
        if (numbers.size() != count) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + count + "개여야 합니다.");
        }
        for (int i = 0; i < count; i++) {
            if (numbers.get(i) < startNumber || numbers.get(i) > endNumber) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + startNumber + "~" + endNumber + " 사이여야 합니다.");
            }
        }
        for (int i = 0; i < count - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

}
