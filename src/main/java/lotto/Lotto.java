package lotto;

import java.net.Inet4Address;
import java.util.List;
import java.util.StringJoiner;

public class Lotto {

    private final String ERROR_LOG = "[ERROR] ";
    private final String INVALID_LOTTO_LENGTH = "로또 번호는 6개여야 합니다.";
    private final String DUPLICATE_LOTTO_NUMBER = "로또 번호는 중복값이 허용되지 않습니다.";

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
            System.out.println(ERROR_LOG + INVALID_LOTTO_LENGTH);
            throw new IllegalArgumentException(ERROR_LOG + INVALID_LOTTO_LENGTH);
        }
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            System.out.println(ERROR_LOG + DUPLICATE_LOTTO_NUMBER);
            throw new IllegalArgumentException(ERROR_LOG + DUPLICATE_LOTTO_NUMBER);
        }
    }

    public boolean hasNumber(int target) {
        return numbers.stream()
                .anyMatch(number -> number.equals(target));
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        numbers.forEach(number -> {
            stringJoiner.add(number.toString());
        });
        return stringJoiner.toString();
    }
}
