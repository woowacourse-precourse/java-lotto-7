package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBER_QUANTITY = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_QUANTITY) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_QUANTITY));
        }
        for (Integer number : numbers) {
            if (!(START_NUMBER <= number && number <= END_NUMBER)) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 당첨 번호는 %d~%d사이의 번호여야 합니다.", START_NUMBER, END_NUMBER)
                );
            }
        }
        isDuplicate(numbers);
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> s = new HashSet<>();
        for (Integer number : numbers) {
            if (!s.add(number)) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 중복된 로또 번호가 있습니다: (%d).", number)
                );
            }
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
