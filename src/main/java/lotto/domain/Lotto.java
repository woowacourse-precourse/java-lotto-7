package lotto.domain;

import static lotto.common.ErrorConstants.ERROR_HEADER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_COUNT = ERROR_HEADER + "로또 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_RANGE = ERROR_HEADER + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE = ERROR_HEADER + "로또 번호는 중복될 수 없습니다.";
    public static final int LOTTO_NUMBER_MAX_COUNT = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_COUNT);
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_RANGE);
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public int matchCount(Lotto winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
