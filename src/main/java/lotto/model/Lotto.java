package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto implements Ticket {
    public static final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicatedNumber(numbers);
        validateRandomNumber(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    private void validateRandomNumber(List<Integer> numbers) {
        boolean isValid = numbers.stream().allMatch(number -> number >= 1 && number <= 45);
        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야합니다.");
        }
    }

    @Override
    public String getTicketInfo() {
        return String.valueOf(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
