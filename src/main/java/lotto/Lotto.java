package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int getNumbersSize() {
        return numbers.size();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containsNumber)
                .count();
    }
}
