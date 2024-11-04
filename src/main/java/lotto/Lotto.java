package lotto;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private static final String ERROR_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_LOTTO_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 로또와 중복되지 않는 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE);
        }
    }

    // TODO: 추가 기능 구현
    public void checkDuplicate(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }

    public Rank countMatchNumber(Lotto winningNumber, int bonusNumber) {
        long matchCount = this.numbers.stream()
                .filter(n -> winningNumber.numbers.stream().anyMatch(Predicate.isEqual(n)))
                .count();
        boolean bonusMatch = this.numbers.stream().anyMatch(Predicate.isEqual(bonusNumber));
        return Rank.findRank(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
