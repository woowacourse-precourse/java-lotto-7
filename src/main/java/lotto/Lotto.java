package lotto;

import java.net.Inet4Address;
import java.util.List;
import java.util.StringJoiner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int calculateEqualCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복값이 허용되지 않습니다.");
        }
    }

    public boolean hasNumber(int target) {
        return numbers.stream()
                .anyMatch(number -> number.equals(target));
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        numbers.forEach(number -> {
            stringJoiner.add(number.toString());
        });
        return stringJoiner.toString();
    }
}
