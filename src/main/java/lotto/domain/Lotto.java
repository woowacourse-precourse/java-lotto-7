package lotto.domain;

import static lotto.message.ErrorMessage.DUPLICATE_LOTTO_NUMBERS_ERROR;

import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_UNIT_PRICE = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public Rank getResult(Set<Integer> winningNumbers, int bonusNumber) {
        List<Integer> missedNumbers = numbers.stream()
                .filter(number -> isMissedNumber(winningNumbers, number))
                .toList();
        return Rank.getRank(missedNumbers, bonusNumber);
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS_ERROR.getMessage());
        }
    }

    private boolean isMissedNumber(Set<Integer> winningNumbers, Integer number) {
        return !winningNumbers.contains(number);
    }
}
